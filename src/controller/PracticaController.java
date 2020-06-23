package controller;

import java.util.List;
import java.util.stream.Collectors;

import collections.PracticaCollection;
import dto.PracticaDTO;

public class PracticaController {
	
	PracticaCollection practicaColeccion = new PracticaCollection();
	
	public void agregarPractica(PracticaDTO p) {
		practicaColeccion.agregarDatos(p);
		practicaColeccion.grabar();
	}
	
	public List<PracticaDTO> listaPracticas(){
		return practicaColeccion.getPracticaList().stream()
				.filter(p->p.isActivo() == true)
				.collect(Collectors.toList());
	}
	
	public List<PracticaDTO> listaPracticasFull(){
		return practicaColeccion.getPracticaList();
	}
	
	
	
	public boolean hayValoresCriticos(int idPractica) {
		return listaPracticas().stream()
		.allMatch((pra -> (pra.getCodigoPractica() == idPractica) && pra.getValoresCriticos() != null));	
	}
	
	public int obtenerUltimoId(){
		List<PracticaDTO> aux = practicaColeccion.getPracticaList();
		int tam = aux.size();
		if(tam > 0) {
			aux.sort((a, b) -> a.getCodigoPractica() - b.getCodigoPractica());
			return aux.get(tam-1).getCodigoPractica();	
		}else {
			return 0;
		}
	}
	
	public void eliminar(int pos) {
		practicaColeccion.eliminar(pos);
	}

	public PracticaDTO obtenerPractica(int selectedRow) {
		return practicaColeccion.getPractica(selectedRow);
	}
}
