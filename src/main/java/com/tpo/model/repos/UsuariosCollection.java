package com.tpo.model.repos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tpo.model.Usuario;

// Se crea un repositorio para contener la lógica de persistencia

@SuppressWarnings("unused")
public final class UsuariosCollection {
	//se usa el patron singleton para que el repositorio solo tenga una instancia
	private static UsuariosCollection INSTANCE;
	//auto incremento para los id simula el secuenciador
	private static int generadorId = 0;
	//simula la bd - map es útil si tiene que buscar, actualizar o eliminar elementos en función de una clave.
	private Map<Integer, Usuario> usuarios = new HashMap<>();
	
	
	/**
	 * verifica si la instancia ya fue creada si tiene una previa devuelve esa, sino crea la nueva clase singleton
	 */
	public static UsuariosCollection getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new UsuariosCollection();
		}
		return INSTANCE;
	}
	//ESTO NO SE SI VA ANDAR
	public List<Usuario> findAll() {
	//	return new ArrayList(usuarios.values());
		return null;
	}

	//Devuelve un paciente buscado por ID
	public Usuario findUsuario (int id)
	{
		Usuario ubuscado = null;//obj usuario nul
		if(usuarios.containsKey(id)) {
			ubuscado = usuarios.get(id); //devuelvo el id del usuario
		}
		else {
			System.out.println("El usuario no existe");
		}
		return ubuscado;
	}
	//Me fijo si el usuario existe en la collection
	public boolean existeUsuario(int usrID) {
		if(usuarios.containsKey(usrID)) {
			return true;
		}
		return false;
	}
	
	//Guardo un usuario en el map
	public void save(Usuario u) {
		usuarios.put(u.getIdUsuario(),u);
	}
	
	//Busco en el map y borro el usuario si existe
	public void delete (int id) {
		if(usuarios.containsKey(id)) {
			usuarios.remove(id);
		}
		else {
			System.out.println("El usario a eliminar no existe");
		}
	}

	public int seq() {
		return generadorId++;
	}
	
}
