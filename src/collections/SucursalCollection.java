package collections;

import model.EstadoSucursal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
	private List<SucursalDTO> sucursales = new ArrayList<>();
	
	public SucursalCollection() 
	{
		addDemoData();
		sucursales = leer();
	}
	
	//Data dummy para mostrar algo
	private void addDemoData() {
		// TODO Auto-generated method stub
		SucursalDTO s = new SucursalDTO();
		s.setIdSucursal(152834);
		s.setDireccion("Estado de Israel 4744");
		s.setResponsableTecnico("Robert Pan");
		s.setEstado(EstadoSucursal.Activa);
		sucursales.add(s);//Guardo la suc dummy
		
	}

	public void eliminar(int id) {
		sucursales.remove(id);
		grabar();
	}
	public List<SucursalDTO> getSucursalesList(){
		return sucursales;
	}
	
	public SucursalDTO getSucursal(int idSuc) {
		return sucursales.get(idSuc);
	}
	
	public void agregarSucursal(SucursalDTO sucursal) {
		sucursales.add(sucursal);
	}
	
	public boolean internalBusucarSucursal(int idSucursal)
	{
		
		for(int i=0;i<sucursales.size(); i++){
			if(sucursales.get(i).getIdSucursal()==idSucursal) {
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
		texto = g.toJson(sucursales);
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
    	ArrayList<SucursalDTO> sucursales = new ArrayList<>();
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
    	        	sucursales.add(g.fromJson(js, SucursalDTO.class));
    	        	b.close();
    	        	return sucursales;
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
		return sucursales;	
    }

}
