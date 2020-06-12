package controller;

import collections.UsuarioCollection;
import dto.UsuarioDTO;

public class UsuarioController {
	UsuarioDTO usuario;
	UsuarioCollection usuarioCollection;
	public UsuarioController() {
		usuario = new UsuarioDTO();
		usuarioCollection = new UsuarioCollection();
	}
	
	public void darDeBaja() {
		
	}
	public UsuarioDTO altaUsuario(String nombreUsuario,String fechaNacimiento, String contraseņa, String domicilio,String nombre, int dni, String mail, String rol) {
		
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setFechaNacimiento(fechaNacimiento);
		usuario.setPassword(contraseņa);
        usuario.setDomicilio(domicilio);
        usuario.setNombre(nombre);
        usuario.setDni(dni);
        usuario.setMail(mail);
        usuario.setRolUsuario(rol);
        
        usuarioCollection.agregarDatos(usuario);
        usuarioCollection.grabar();
        return usuario;
    }
	
	public UsuarioDTO getUsuarioDTO() {
		return usuario;
	}
}
