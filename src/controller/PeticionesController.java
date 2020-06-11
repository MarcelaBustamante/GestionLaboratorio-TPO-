package Controller;

import collections.PeticionCollection;
import dto.PeticionDTO;

public class PeticionesController {

	PeticionCollection peticionColeccion = new PeticionCollection();
	public void agregarPeticion(PeticionDTO p) {
		peticionColeccion.agregarDatos(p);
		peticionColeccion.grabar();
	}
	

}
