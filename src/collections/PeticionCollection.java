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



public class PeticionCollection {
private List<PeticionDTO> datos = new ArrayList<>();
	
	public PeticionCollection()
	{
		 // addDemoData();
		 datos = leer();
		
	}
	
	public List<PeticionDTO> getPeticionesList()
	{
		return datos;
	}
	
	public PeticionDTO getPeticion(int index)
	{
		return datos.get(index);
	}
	
	public void agregarDatos(PeticionDTO peticion) {
		datos.add(peticion);
	}
	
	public void addDemoData(){ 
		PeticionDTO p = new PeticionDTO();
		p.setIdPeticion(1);
		p.setIdSucursal(1);
		p.setDniPaciente(94472131);
		p.setObraSocial("OSDE");
		datos.add(p);
	}
	
	public void grabar() {
		File archivo = new File("peticiones.txt");
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datos);
		//grabo el String
		try (
			FileWriter fileWriter = new FileWriter(archivo);
			BufferedWriter writer = new BufferedWriter(fileWriter);
		) {
			//Este bloque de codigo obligatoriamente debe ir dentro de un try.
			writer.write(texto);
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	
    private List<PeticionDTO> leer() {
    	ArrayList<PeticionDTO> peticiones = new ArrayList<>();
        String cadena;
        File archivo = new File("peticiones.txt");
        if(archivo.exists()) {
        	 System.out.println("lo encontró");
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
