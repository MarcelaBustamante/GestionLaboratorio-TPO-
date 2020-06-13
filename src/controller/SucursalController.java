package controller;
import java.util.ArrayList;
import java.util.List;

import model.EstadoSucursal;
import model.Sucursal;

public class SucursalController {
	private List<Sucursal> listaSucursales;
	private static SucursalController instance;
	
	private SucursalController()
	{
		listaSucursales = new ArrayList<Sucursal>();//listado de sucursales
	}
	
	public static SucursalController getInstance()
	{
		if (instance==null)
			instance = new SucursalController();
		return instance;
	}
	//Definicion de controller singleton
	
	
	
	public void addSucursal(String direccion, String responsableTecnico, int idSucursal) {
		
		Sucursal nuevaSuc = new Sucursal();
		nuevaSuc.setDireccion(direccion);
		nuevaSuc.setIdSucursal(idSucursal);
		nuevaSuc.setResponsableTecnico(responsableTecnico);
		listaSucursales.add(nuevaSuc);
	}
	
	
	public Sucursal internalBusucarSucursal(int idSucursal)
	{
		
		for(int i=0; i<listaSucursales.size(); i++){
			if(listaSucursales.get(i).getIdSucursal()==idSucursal) {
				return listaSucursales.get(i);
			}
		}
		return null;
	}
	
	private void cambiarEstado(int idSucursal) {
		for(int i=0; i<listaSucursales.size(); i++){
			if(listaSucursales.get(i).getIdSucursal()==idSucursal) {
				listaSucursales.get(i).setEstado(EstadoSucursal.Inactiva);
				break;
			}
		}
	}
	
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
