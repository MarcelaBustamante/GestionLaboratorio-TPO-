package collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import dto.PeticionDTO;
import dto.PracticaDTO;;

public class PracticaCollection {
	private List<PracticaDTO> datos;
	
	public PracticaCollection()
	{
		leer();
		
	}
	
	public void agregarDatos(PracticaDTO practica) {
		datos.add(practica);
	}
	
	public List<PracticaDTO> getPracticaList()
	{
		return datos;
	}
	
	public PracticaDTO getPractica(int index)
	{
		return datos.get(index);
	}
	
	

	public void grabar() {
		String nombreArchivo = "practicas.txt";
		try {
			FileUtils.grabar(nombreArchivo, datos);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
		/*
		File archivo = new File("./personas.txt");
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
		*/
	
    private List<PracticaDTO> leer() {
    	String nombreArchivo = "practicas.txt";
		try {
			datos = FileUtils.leer(nombreArchivo, PracticaDTO.class);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return datos;
    }
    	/*
    	ArrayList<PracticaDTO> personas = new ArrayList<PracticaDTO>();
        String cadena;
        File archivo = new File("./personas.txt");
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
    	        for(JsonElement js : gsonArr) //System.out.println(js.toString());
    	        	personas.add(g.fromJson(js, PracticaDTO.class));
    	        
    	        b.close();
    	        
    	        //for(Object o : aux)
    	        //	scores.add((Score) o);
    	        return personas;
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		return personas;
		
    }
    */

}
