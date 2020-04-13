package com.tpo.model.repos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tpo.model.Paciente;

/**
 * Se crea un repositorio para contener la lógica de persistencia
 * @author BUSTAMJM
 *
 */
public final class PacienteRepository {
	//se usa el patron singleton para que el repositorio solo tenga una instancia
	private static PacienteRepository INSTANCE;
	//auto incremento para los id simula el secuenciador
	private static int generadorId = 0;
	//simula la bd
	private Map<Integer, Paciente> pacientes = new HashMap<>();
	
	
	/**
	 * verifica si la instancia ya fue creada si tiene una previa devuelve esa
	 */
	public static PacienteRepository getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PacienteRepository();
		}
		return INSTANCE;
	}
	
	
	/**
	 * devuelve la lista de pacientes
	 * @return
	 */
	public List<Paciente> findAll() {
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
			pacientes.remove(paciente);
	}
	
	
}
