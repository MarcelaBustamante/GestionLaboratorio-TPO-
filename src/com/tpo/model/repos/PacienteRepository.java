package com.tpo.model.repos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.tpo.model.Paciente;

/**
 * Se crea un repositorio para contener la lógica de persistencia
 * @author BUSTAMJM
 *
 */
public class PacienteRepository {
	//auto incremento para los id simula el secuenciador
	private static int generadorId = 0;
	//simula la bd
	private Map<Integer, Paciente> pacientes = new HashMap<>();
	
	/**
	 * devuelve la lista de pacientes
	 * @return
	 */
	public ArrayList findAll() {
		return new ArrayList(pacientes.values());
	}
	/**
	 * devuelve un solo paciente
	 * @param id
	 * @return
	 */
	public Paciente findOne(int id) {
		Paciente resultado = null;		
		if (pacientes.containsKey(id)) {
				resultado = pacientes.get(id);
			}else {
				System.out.println("El paciente no existe");
			}
			return resultado;
	}
	/**
	 * guarda un paciente en el repo
	 * @param p
	 */

	public void save(Paciente p) {
		pacientes.put(p.getIdPaciente(), p);
	}
	
	public int seq() {
		return generadorId++;
	}
	
	/**
	 * Elimina un paciente si y solo si no tiene peticiones completas
	 * @param paciente
	 */
	public void delete(int paciente) {
		if(tienePeticionesCompletas()) {
			//TODO ver como explica el profe como manejar los errores para pasar a la vista
			System.out.println("El paciente posee peticiones completas");
		} else {
			pacientes.remove(paciente);
		}
		
	}
	
	private boolean tienePeticionesCompletas() {
		// TODO Aqui es necesiario traer el otro repo de peticiones por eso se creo clases repositorio
		return false;
	}
}
