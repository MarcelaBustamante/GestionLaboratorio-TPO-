package controller;

import java.util.ArrayList;
import java.util.List;

import model.EstadoPeticion;
import model.Peticion;

public class PeticionesController {
		private static PeticionesController instance;
		private List<Peticion> listaPeticiones;

		
		
		private PeticionesController()
		{
			listaPeticiones = new ArrayList<Peticion>();//listado de peticiones
		}
		
		//Declaracion de signleton del controlador
		public static PeticionesController getInstance()
		{
			if (instance==null)
				instance = new PeticionesController();
			return instance;
		}
		

		
		public List<Peticion> getPeticionesPorSucursal(int idSucursal) {

			List<Peticion> peticionesDeSucursal = new ArrayList<Peticion>();
			for(int i=0; i<listaPeticiones.size(); i++)
			{
				if(listaPeticiones.get(i).getIdSucursal()==idSucursal)
				{
					peticionesDeSucursal.add(listaPeticiones.get(i));
				}
			}
			return peticionesDeSucursal;
			}
		
		public boolean peticionFinalizada (int idSucursal) {
			
			List<Peticion> PeticionesActivas = getPeticionesPorSucursal(idSucursal);
			
			for(int i=0; i<PeticionesActivas.size();i++) {
				if(PeticionesActivas.get(i).getEstado()==EstadoPeticion.Finalizada) {
					return true;
				}
			}		
			return false;
		}


}
