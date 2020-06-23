package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import collections.PacienteCollection;
import collections.SucursalCollection;
import dto.PacienteDTO;
import dto.PeticionDTO;
import model.EstadoPeticion;

public class PacienteController {

	PacienteCollection pacienteCollection = new PacienteCollection();
	PeticionesController controladorPeticion;
	
	public PacienteController() {
		controladorPeticion = new PeticionesController();
	}
	public void agregarPaciente(PacienteDTO p) {
		pacienteCollection.agregarDatos(p);
		pacienteCollection.grabar();
	}

	public List<PacienteDTO> listaPacientes() {
		
		return pacienteCollection.getPacientesList() ;
	}

	public PacienteDTO obtenerPaciente(int id) {
		return pacienteCollection.getPaciente(id);
	}
	
	public void eliminarPaciente(int id){
		 pacienteCollection.eliminar(id);
	}
	public boolean existePaciente(int dni) {
		return pacienteCollection.getPacientesList().stream()
				.anyMatch((pac-> pac.getDni() ==dni));
	}
	public boolean existepaciente(int dni,String mail, String nombre, String domicilio) {
	return pacienteCollection.getPacientesList().stream()
			.anyMatch((pac->(pac.getDni() ==dni) && (pac.getMail().equals(mail) && ((pac.getNombre().equals(nombre)) && ((pac.getDomicilio().equals(domicilio)))))));
	}
	public boolean existePetiFinalizada(int indice) {
		if(controladorPeticion.existePeticionFin(pacienteCollection.getPacientesList().get(indice).getDni()))	
		{ 
			return true;
		}
		else
		{
			eliminarPaciente(indice);
			return false;
		}
	}
	public int obtenerUltimoId() {
		
		List<PacienteDTO> aux = listaPacientes(); 
		aux.sort((a, b) -> a.getIdPaciente());
		return aux.get(aux.size() - 1).getIdPaciente();
	}
}
