package controller;

import java.util.List;

import collections.SucursalCollection;
import dto.SucursalDTO;
import model.EstadoSucursal;

public class SucursalController {
	SucursalDTO suc;
	SucursalCollection sucCollection;
	PeticionesController controladorPeticion;
	
	public SucursalController() {
	suc = new SucursalDTO();
	sucCollection = new SucursalCollection();
	controladorPeticion = new PeticionesController();
	}


	

	public void eliminarSucursal(int indice) {
		sucCollection.eliminar(indice);
	}
	
	public boolean existePetiFinalizada(int indice) {
		
		if(controladorPeticion.existePeticionFinalizadaSuc(sucCollection.getSucursalesList().get(indice).getIdSucursal()))	
		{ 
			System.out.print("No se puede borrar");
			return true;
		}
		else
		{
			eliminarSucursal(indice);
			
			return false;
		}
	}
	
	public List<SucursalDTO> listarSucursales(){
		return sucCollection.getSucursalesList();
	}
//public SucursalCollection
////	private static SucursalController instance;
//	
////	private SucursalController()
////	{
////		listaSucursales = new ArrayList<Sucursal>();//listado de sucursales
////	}
////	
//	public static SucursalController getInstance()
//	{
//		if (instance==null)
//			instance = new SucursalController();
//		return instance;
//	}
//	//Definicion de controller singleton
//	
	public void agregarSucursal(SucursalDTO s) {
		sucCollection.agregarSucursal(s);
		sucCollection.grabar();
	}
	
	
	public SucursalDTO addSucursal(String direccion, String responsableTecnico, int idSucursal, EstadoSucursal estado) {
		
		suc.setDireccion(direccion);
		suc.setEstado(estado);
		suc.setIdSucursal(idSucursal);
		suc.setResponsableTecnico(responsableTecnico);
		sucCollection.agregarSucursal(suc);
		sucCollection.grabar();
		return suc;
	}
	
	
	public SucursalDTO getSucursal(int id)
	{
		return sucCollection.getSucursal(id);
	}
//	

//	
//	private void cambiarEstado(int idSucursal) {
//		for(int i=0; i<listaSucursales.size(); i++){
//			if(listaSucursales.get(i).getIdSucursal()==idSucursal) {
//				listaSucursales.get(i).setEstado(EstadoSucursal.Inactiva);
//				break;
//			}
//		}
//	}
//	
//	public boolean bajaSucursal(int idSucursal) {
//		
//		Sucursal unaSucursal = internalBusucarSucursal(idSucursal); //me fijo si existe la sucursal
//		
//		if(unaSucursal==null) {
//			return false;
//		}
//		if(unaSucursal.getEstado()==EstadoSucursal.Inactiva) {//si existe me fijo que no este inactiva
//			return false;
//		}
//		 boolean tienepeticion = PeticionesController.getInstance().peticionFinalizada(unaSucursal.getIdSucursal());
//		 if(tienepeticion){
//			 System.out.print("poner el id de sucursal que no puedo eliminar");
//			 return false;
//			 }
//		 
//		 cambiarEstado(unaSucursal.getIdSucursal());
//		 return true;
//		 
//		}
	

	
}
