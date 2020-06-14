package controller;

import java.util.List;

import collections.PeticionCollection;
import dto.PeticionDTO;

public class PeticionesController {

	PeticionCollection peticionColeccion = new PeticionCollection();
	public void agregarPeticion(PeticionDTO p) {
		peticionColeccion.agregarDatos(p);
		peticionColeccion.grabar();
	}
	
	public List<PeticionDTO> listaPeticiones(){
		return peticionColeccion.getPeticionesList();
	}
	
	public PeticionDTO obtenerPeticion(int id) {
		return peticionColeccion.getPeticion(id);
	}
	
	
}
