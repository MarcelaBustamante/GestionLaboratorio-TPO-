package com.tpo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tpo.model.Paciente;
import com.tpo.model.repos.PacienteRepository;

/**
 * Controller de pacientes
 * @author BUSTAMJM
 *
 */
public class PacienteController {
	
	private PacienteRepository pacienteRepository = new PacienteRepository();
	
	
	/**
	 * Devolver listado de pacientes del sistema
	 * @return 
	 */
	public List<Paciente> getPacientes(){
		return pacienteRepository.findAll();
	}
	
	/**
	 * agregar un paciente nuevo
	 */
	public void addPaciente(PacienteDTO unPaciente) {
	
		Paciente nuevoPaciente = new Paciente();
		nuevoPaciente.setIdPaciente(pacienteRepository.seq());
		nuevoPaciente.setDni(unPaciente.getDni());
		nuevoPaciente.setDomicilio(unPaciente.getDomicilio());
		nuevoPaciente.setEdad(unPaciente.getEdad());
		nuevoPaciente.setMail(unPaciente.getMail());
		nuevoPaciente.setNombre(unPaciente.getNombre());
		nuevoPaciente.setSexo(unPaciente.getSexo());		
		pacienteRepository.save(nuevoPaciente);
	}
	
	/**
	 * obtener un paciente por id
	 */
	public Paciente getPaciente(int paciente) {
		return pacienteRepository.findOne(paciente);
	}
	
	/**
	 * eliminar un paciente por id
	 */
	public void remove(int paciente) {
		pacienteRepository.delete(paciente);
	}
	
	
/**
 * Modifica un paciente con solo tener su id
 * @param idPaciente
 */
	public void update(int idPaciente, PacienteDTO p) {
		Paciente aux = pacienteRepository.findOne(idPaciente);
		if(aux == null) {
			System.out.println("No se pudo modificar el paciente");
		}else {
			aux.setDni(p.getDni());
			aux.setDomicilio(p.getDomicilio());
			aux.setEdad(p.getEdad());
			aux.setMail(p.getMail());
			aux.setNombre(p.getNombre());
			aux.setSexo(p.getSexo());
			aux.setUrl(p.getUrl());
			pacienteRepository.save(aux);
		}
	}
}
