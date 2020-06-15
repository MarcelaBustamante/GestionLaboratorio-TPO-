package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import collections.PeticionCollection;
import dto.PeticionDTO;
import model.EstadoPeticion;

public class PeticionesController {

	PeticionCollection peticionColeccion = new PeticionCollection();
	PracticaController controladorPractica = new PracticaController();
	boolean valoresCriticosFiltro ;
	
	public PeticionesController() {
		
	}
	public PeticionesController(boolean selected) {
		valoresCriticosFiltro = selected;
	}

	public void agregarPeticion(PeticionDTO p) {
		peticionColeccion.agregarDatos(p);
		peticionColeccion.grabar();
	}

	public List<PeticionDTO> listaPeticiones() {
		
		return peticionColeccion.getPeticionesList() ;
	}

	public PeticionDTO obtenerPeticion(int id) {
		return peticionColeccion.getPeticion(id);
	}
	
	public void eliminarPeticion(int id){
		 peticionColeccion.eliminar(id);
	}

	/**
	 * esta funcion devuelve verdadero siempre y cuando no haya peticiones completas
	 * 
	 * @param dni
	 * @return boolean
	 */
	public boolean existePeticionActiva(int dni) {
		return peticionColeccion.getPeticionesList().stream()
				.anyMatch((pet -> (pet.getDniPaciente() == dni) && (pet.getEstado() != EstadoPeticion.Finalizada)));
	}

	public List<PeticionDTO> listaPeticionesResCriticos() {
		return listaPeticiones().stream()
				.filter(pet -> controladorPractica.hayValoresCriticos(pet.getDniPaciente()))
				.collect(Collectors.toList());

	}
}