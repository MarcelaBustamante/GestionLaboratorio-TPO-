package collections;

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

import dto.PeticionDTO;
import model.EstadoPeticion;



public class PeticionCollection {
private List<PeticionDTO> datos = new ArrayList<>();
	
	public PeticionCollection()
	{
		addDemoData();
		// datos = leer();
		
	}
	
	public List<PeticionDTO> getPeticionesList()
	{
		return datos;
	}
	
	public PeticionDTO getPeticion(int index)
	{
		return datos.get(index);
	}
	
	public void addDemoData(){ 
		PeticionDTO p = new PeticionDTO();
		p.setIdPeticion(1);
		p.setIdSucursal(1);
		p.setUnPaciente("July");
		p.setObraSocial("OSDE");
		datos.add(p);
	}
	
	public void grabar() {
		File archivo = new File("./peticiones.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datos);
		//grabo el String
		try{
			//Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fileWriter = new FileWriter(archivo);
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();		
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	
    private List<PeticionDTO> leer() {
    	ArrayList<PeticionDTO> peticiones = new ArrayList<>();
        String cadena;
        File archivo = new File("./peticion.txt");
        if (archivo.exists())
        {
            FileReader f;
    		try {
    			f = new FileReader(archivo);
    	        BufferedReader b = new BufferedReader(f);
    	        cadena = b.readLine();
    	        System.out.println(cadena);
    	        JsonParser parser = new JsonParser();
    	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
    	        Gson g = new Gson();
    	        for(JsonElement js : gsonArr)
    	        	peticiones.add(g.fromJson(js, PeticionDTO.class));
    	        	b.close();
    	        	return peticiones;
    		} catch (IOException e) {

    			e.printStackTrace();
    		}
        }
		return peticiones;
		
    }

}
