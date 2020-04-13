package com.tpo.model.repos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tpo.model.Peticion;

/**
 * Se crea un repositorio para contener la lógica de persistencia
 * @author BUSTAMJM
 *
 */
public final class PeticionRepository {
	/**se usa el patron singleton para que el repositorio solo tenga una instancia
	 *Ya que es un repositorio
	 */
	private static PeticionRepository INSTANCE;
	//auto incremento para los id simula el secuenciador
	private static int generadorId = 0;
	//simula la bd
	private Map<Integer, Peticion> peticiones = new HashMap<>();
	
	/**
	 * verifica si la instancia ya fue creada si tiene una previa devuelve esa
	 */
	public static PeticionRepository getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PeticionRepository();
		}
		return INSTANCE;
	}
	/**
	 * devuelve la lista de peticion
	 * @return
	 */
	public List<Peticion> findAll() {
		return new ArrayList(peticiones.values());
	}
	/**
	 * devuelve una peticion 
	 * @param id
	 * @return
	 */
	public Peticion findOne(int id) {
		Peticion resultado = null;		
		if (peticiones.containsKey(id)) {
				resultado = peticiones.get(id);
			}else {
				System.out.println("El paciente no existe");
			}
			return resultado;
	}
	/**
	 * guarda un paciente en el repo
	 * @param p
	 */

	public void save(Peticion p) {
		peticiones.put(p.getIdPeticion(), p);
	}
	
	public int seq() {
		return generadorId++;
	}
	
	/**
	 * Elimina un paciente si y solo si no tiene peticiones completas
	 * @param paciente
	 */
	public void delete(int peticion) {
			peticiones.remove(peticion);
	}
	
}
