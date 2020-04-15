package com.tpo.controller;
import java.util.List;
import java.util.stream.Collectors;
import com.tpo.model.Usuario;
import com.tpo.model.repos.UsuariosCollection;

/**
 * Controller de usuarios
 */
@SuppressWarnings("unused")
public class UsuarioController {
	
	//Me traigo la collection de usuarios 
	private UsuariosCollection usuariosCollection = UsuariosCollection.getInstance();

	//Devuelve listado de usuarios
	public List<Usuario> getUsuarios(){
		return usuariosCollection.findAll();
	}
	//Agrega un nuevo usuario
	public void addUsuario(UsuarioDTO usuarioDTO) {
		Usuario nuevoUsuario = new Usuario();
		
		nuevoUsuario.setIdUsuario(usuarioDTO.getIdUsuario());
		nuevoUsuario.setUsuario(usuarioDTO.getUsuario());
		nuevoUsuario.setNombre(usuarioDTO.getNombre());
		nuevoUsuario.setDni(usuarioDTO.getDni());
		nuevoUsuario.setDomicilio(usuarioDTO.getDomicilio());
		//nuevoUsuario.setFechaNacimiento(usuarioDTO.get);
		//nuevoUsuario.setPassword(usuarioDTO.get);
		nuevoUsuario.setEmail(usuarioDTO.getEmail());
		//nuevoUsuario.getUserRol(usuarioDTO.getRolusuario());
		
		usuariosCollection.save(nuevoUsuario);//
		
	

	}
	
	//Busca un usuario de la collection
	public Usuario getUsuario(int usuario) {
		return usuariosCollection.findUsuario(usuario);
	}
	
	public void removeUsuario(int usrID) {
		if(usuariosCollection.existeUsuario(usrID)){
			usuariosCollection.delete(usrID);
		}
		System.out.println("El usuario "+ usrID +" no existe en el sistema");
	}
	
	//Actualiza un usuario por medio del id
	public void update (int usrID, UsuarioDTO newUsr) {
		Usuario aux = usuariosCollection.findUsuario(usrID);//Me traigo el usuario buscado, si no existe es null
		if(aux==null)
			System.out.println("El usuario buscado no existe");
		else {
			//actualizo aux y despues lo guardo
			aux.setDni(newUsr.getDni());
			aux.setDomicilio(newUsr.getDomicilio());
			aux.setEmail(newUsr.getEmail());
			aux.setNombre(newUsr.getNombre());
			aux.setIdUsuario(newUsr.getIdUsuario());
			usuariosCollection.save(aux);
		}
	}
}
