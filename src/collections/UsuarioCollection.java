package collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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

import dto.PeticionDTO;
import dto.UsuarioDTO;
import model.RolUsuario;

public class UsuarioCollection {
	private List<UsuarioDTO> datos = new ArrayList<>();
	public UsuarioCollection()
	{
		addDemoData();
		datos = leer();
	}
	public List<UsuarioDTO> getUsuariosList()
	{
		return datos;
	}
	
	public UsuarioDTO getUsuario(int index)
	{
		return datos.get(index);
	}
	public void addDemoData()
	{
		UsuarioDTO u = new UsuarioDTO();
		u.setNombreUsuario("Carl523");
		u.setMail("carl@hotmail.com");
		u.setPassword("Maracan983");
		u.setNombre("Carlos Rodriguez");
		u.setDomicilio("Avenida Independencia 883");
		u.setDni(4862335);
		u.setFechaNacimiento("25/07/1995");
		u.setRolUsuario(RolUsuario.laboratorista);
		datos.add(u);
	}
	public void grabar() {
		String nombreArchivo = "peticiones.txt";
		try {
			FileUtils.grabar(nombreArchivo, datos);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
    private List<UsuarioDTO> leer() {
    	String nombreArchivo = "peticiones.txt";
		try {
			datos = FileUtils.leer(nombreArchivo, UsuarioDTO.class);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return datos;
    }
}
