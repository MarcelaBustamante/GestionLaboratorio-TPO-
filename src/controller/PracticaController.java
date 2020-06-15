package controller;

import java.util.List;

import collections.PracticaCollection;
import dto.PracticaDTO;

public class PracticaController {
	
	PracticaCollection practicaColeccion = new PracticaCollection();
	public void agregarPractica(PracticaDTO p) {
		practicaColeccion.agregarDatos(p);
		practicaColeccion.grabar();
	}
	public List<PracticaDTO> listaPracticas(){
		return practicaColeccion.getPracticaList();
	}
	
	public boolean hayValoresCriticos(int idPractica) {
		return listaPracticas().stream()
		.allMatch((pra -> (Integer.parseInt(pra.getCodigoPractica()) == idPractica) && pra.getValoresCriticos() != null));	
	}
}
