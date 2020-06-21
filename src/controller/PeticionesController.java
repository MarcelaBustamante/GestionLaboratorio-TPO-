package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import collections.PeticionCollection;
import dto.PeticionDTO;
import model.EstadoPeticion;
import model.TipoValorCritico;

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
	
	//Metodo que devuelve las peticiones de una sucursal en especifico
	public List<PeticionDTO> listaPeticionesSuc(int idSuc)
	{
		List<PeticionDTO> listaPetiSuc = new ArrayList<PeticionDTO>();
		 for(int i=0;i<peticionColeccion.getPeticionesList().size();i++) {
			 if(peticionColeccion.getPeticion(i).getIdSucursal()==idSuc) {
				 listaPetiSuc.add(peticionColeccion.getPeticion(i));
			 }
				 
		 }
		 return listaPetiSuc;
	}
	
	public void DerivarPeticiones(int sucOrigen,int sucDestino)
	{
		 for(int i=0;i<peticionColeccion.getPeticionesList().size();i++) {
			 if(peticionColeccion.getPeticion(i).getIdSucursal()==sucOrigen) {
				 peticionColeccion.getPeticion(i).setIdSucursal(sucDestino);
			 }
		 }
	
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
	
	/**
	 * funcion que indica si la peticion ha sido finalizada, buscandola por sucursal
	 * @param idSuc
	 * @return
	 */
	
	/**Esta funcion verifica si la sucursal indicada tiene algun tipo peticion activa*/
	public boolean existePeticionActEnSuc(int idSuc)
	{
		return peticionColeccion.getPeticionesList().stream()
				.anyMatch((pet -> (pet.getIdSucursal() == idSuc) && (pet.getEstado() == EstadoPeticion.Activa)));
	}
	
	public boolean existePeticionFinalizadaSuc(int idSuc) {
		for(int i=0;i<peticionColeccion.getPeticionesList().size();i++) {
			if(peticionColeccion.getPeticion(i).getIdSucursal()==idSuc && peticionColeccion.getPeticion(i).getEstado()==EstadoPeticion.Finalizada)
			return true;
		}
		return false;
	}

	public List<PeticionDTO> listaPeticionesResCriticos() {
		List<PeticionDTO> peticiones = peticionColeccion.getPeticionesList();
		List<PeticionDTO> aux = new ArrayList<PeticionDTO>();
		for (PeticionDTO peticionDTO : peticiones) {
			if(peticionDTO.getResultados().stream()
			.anyMatch(res -> res.getTipoValCri() == TipoValorCritico.Critico)) {
				aux.add(peticionDTO);
			};
		}
		return aux;
	}
	
	/**
	 * Este m�todo permite cerrar el flujo de la peticion en finalizado luego 
	 * de cargar los resultados correspondientes
	 * @param p
	 */
	public void cerrarPeticion(PeticionDTO p) {
		p.setEstado(EstadoPeticion.Finalizada);
		agregarPeticion(p);
	}
	
	/**
	 * Este m�todo permite cerrar el flujo de la peticon con estado rechazado
	 * si hay que repetir analisis
	 * @param p
	 */
	public void rechazarPeticion(PeticionDTO p) {
		p.setEstado(EstadoPeticion.Rechazada);
		agregarPeticion(p);
	}
	public int obtenerUltimoId() {
		
		List<PeticionDTO> aux = listaPeticiones(); 
		aux.sort((a, b) -> a.getIdPeticion() - b.getIdPeticion());
		return aux.get(aux.size() - 1).getIdPeticion();
	}
}