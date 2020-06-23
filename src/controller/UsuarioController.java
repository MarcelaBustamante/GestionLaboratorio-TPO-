package controller;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import collections.UsuarioCollection;
import dto.PacienteDTO;
import dto.UsuarioDTO;
import model.EstadoPeticion;

public class UsuarioController {

	UsuarioCollection usuarioCollection = new UsuarioCollection();
	PacienteController controladorPaciente;
	
	public UsuarioController() {
	}
	public void agregarUsuario(UsuarioDTO p) {
		usuarioCollection.agregarDatos(p);
		usuarioCollection.grabar();
	}

	public List<UsuarioDTO> listaUsuarios() {
		return usuarioCollection.getUsuariosList() ;
	}

	public UsuarioDTO obtenerUsuario(int dni) {
		return usuarioCollection.getUsuario(dni);
	}
	public int getUserDni(String username) {
		
		List<UsuarioDTO> usu = usuarioCollection.getUsuariosList();
		int dni = 0;
		
		for(UsuarioDTO usuarioDTO : usu) {
			if(username == usuarioDTO.getNombreUsuario()) {
				dni = usuarioDTO.getDni();
			}
		}
		
		return dni;
	}

	public void eliminarUsuario(int dni){
		 usuarioCollection.eliminar(dni);
	}
	public boolean checkLogin(String nombreUsuario, String contra) {
		
		if(usuarioCollection.getUsuariosList().stream().anyMatch((usu -> (usu.getNombreUsuario().equals(nombreUsuario)) && (usu.getPassword().equals(contra))))) {
			return true;
		}
		else {
			return false;
		}	
	}
	public boolean checkRol(String nombreUsuario, String rol) {
		
		if(usuarioCollection.getUsuariosList().stream().anyMatch((usu -> (usu.getNombreUsuario().equals(nombreUsuario)) && (usu.getRolUsuario().equals(rol))))) {
			return true;
		}
		else {
			return false;
		}	
	}
	public boolean existeusuario(String nombreUsuario)
	{
		if(usuarioCollection.internalBuscarUsuario(nombreUsuario))
			return true;
		else
			return false;
	}
	public boolean existeUsuario(String nombreUsuario) {
		return usuarioCollection.getUsuariosList().stream()
				.anyMatch((usu -> (usu.getNombreUsuario().equals(nombreUsuario))));
	}
	/*public boolean existeUsuario(String nombreUsuario, String contra)
	{
		if(usuarioCollection.internalBuscar(nombreUsuario,contra))
			return true;
		else
			return false;
	}*/
}