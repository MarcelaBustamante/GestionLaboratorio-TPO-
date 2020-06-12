package controller;

import collections.PracticaCollection;
import dto.PracticaDTO;

public class PracticaController {
	
	PracticaCollection practicaColeccion = new PracticaCollection();
	public void agregarPractica(PracticaDTO p) {
		practicaColeccion.agregarDatos(p);
		practicaColeccion.grabar();
	}
}
