package collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import dto.UsuarioDTO;

public class UsuarioCollection {
	private List<UsuarioDTO> datos;

	public UsuarioCollection() {
		datos = leer();

	}

	public List<UsuarioDTO> getUsuariosList() {
		return datos;
	}

	public UsuarioDTO getUsuario(int index) {
		return datos.get(index);
	}
	public UsuarioDTO getUsuarioDni(int dni){
		for (UsuarioDTO usuarioDTO : datos) {
			if(dni == usuarioDTO.getDni()) {
				return usuarioDTO;
			}
		}
		return null;
	}
	public void agregarDatos(UsuarioDTO usuario) {
		UsuarioDTO p = getUsuarioDni(usuario.getDni());
		if(p != null) {
			p.setNombreUsuario(usuario.getNombreUsuario());
			p.setMail(usuario.getMail());
			p.setPassword(usuario.getPassword());
			p.setNombre(usuario.getNombre());
			p.setDomicilio(usuario.getDomicilio());
			p.setDni(usuario.getDni());
			p.setFechaNacimiento(usuario.getFechaNacimiento());
			p.setRolUsuario(usuario.getRolUsuario());
		}else {
			datos.add(usuario);
		}
	}
	public boolean internalBuscarUsuario(String nombreUsuario)
	{
		for(int i=0;i<datos.size(); i++){
			if(datos.get(i).getNombreUsuario().equals(nombreUsuario)) {
				return true;
			}
		}
		return false;
	}
	/*public boolean internalBuscar(String nombreUsuario, String contra)
	{
		for(int i=0;i<datos.size(); i++){
			if(datos.get(i).getNombreUsuario().equals(nombreUsuario) && datos.get(i).getPassword().equals(contra)) {
				return true;
			}
		}
		return false;
	}*/
	


	public void grabar() {
		try {
			FileUtils.grabar("usuarios.txt", datos);
		} catch (Exception ex) {
			datos = new ArrayList<>();
			System.out.println(ex.getMessage());
		}
	}

	private List<UsuarioDTO> leer() {
		try {
			datos = FileUtils.leer("usuarios.txt", UsuarioDTO.class);
		}catch (Exception e) {
			//si no existe el archivo lo crea 
			datos = new ArrayList<>();
			System.out.println(e.getMessage());
		}
		return datos;
	}

	public void eliminar(int dni) {
		datos.remove(dni);
		grabar();
	}
}
