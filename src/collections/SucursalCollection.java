package collections;

import model.EstadoSucursal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import dto.SucursalDTO;

public class SucursalCollection {
	private List<SucursalDTO> datos = new ArrayList<>();
	
	public SucursalCollection() 
	{
		addDemoData();
		datos = leer();
	}
	
	//Data dummy para mostrar algo
	private void addDemoData() {
		// TODO Auto-generated method stub
		SucursalDTO s = new SucursalDTO();
		s.setIdSucursal(152834);
		s.setDireccion("Estado de Israel 4744");
		s.setResponsableTecnico("Robert Pan");
		s.setEstado(EstadoSucursal.Activa);
		datos.add(s);//Guardo la suc dummy
		
	}

	public void eliminar(int id) {
		datos.remove(id);
		grabar();
	}
	public List<SucursalDTO> getSucursalesList(){
		return datos;
	}
	
	public SucursalDTO getSucursal(int idSuc) {
		return datos.get(idSuc);
	}
	
	public SucursalDTO getPeticionId(int id) {
		for (SucursalDTO sucursalDTO : datos) {
			if(id == sucursalDTO.getIdSucursal()) {
				return sucursalDTO;
			}
		}
		return null;
	}
	public void agregarSucursal(SucursalDTO sucursal) {
		SucursalDTO s =getPeticionId(sucursal.getIdSucursal());
		if(s != null) {
			s.setIdSucursal(sucursal.getIdSucursal());
			s.setDireccion(sucursal.getDireccion());
			s.setResponsableTecnico(sucursal.getResponsableTecnico());
			s.setEstado(sucursal.getEstado());
		}else {
			datos.add(sucursal);
		}
	}
	
	public boolean internalBusucarSucursal(int idSucursal)
	{
		
		for(int i=0;i<datos.size(); i++){
			if(datos.get(i).getIdSucursal()==idSucursal) {
				return true;
			}
		}
		return false;
	}
	
	public void grabar() {
		//File archivo = new File("sucursales.txt"); //creo el archivo
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datos);
		//grabo el String
		try{
			//Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fileWriter = new FileWriter("sucursales.txt");
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();		
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	
	private List<SucursalDTO> leer() {
    	ArrayList<SucursalDTO> datos = new ArrayList<>();
        String cadena;
        
            FileReader f;
    		try {
    			f = new FileReader("sucursales.txt");
    	        BufferedReader b = new BufferedReader(f);
    	        cadena = b.readLine();
    	        System.out.println(cadena);
    	        JsonParser parser = new JsonParser();
    	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
    	        Gson g = new Gson();
    	        for(JsonElement js : gsonArr)
    	        	datos.add(g.fromJson(js, SucursalDTO.class));
    	        	b.close();
    	        	return datos;
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
		return datos;	
    }

}
