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

import dto.PracticaDTO;
import dto.UsuarioDTO;

public class PracticaCollection {
	private List<PracticaDTO> datos = new ArrayList<>();
	public PracticaCollection()
	{
		//addDemoData();
		datos = leer();
	}
	public List<PracticaDTO> getPracticaList()
	{
		return datos;
	}
	
	public PracticaDTO getPractica(int index)
	{
		return datos.get(index);
	}
	
	public void agregarDatos(PracticaDTO practica) {
		datos.add(practica);
	}
	
	/*public void addDemoData()
	{
		UsuarioDTO p = new UsuarioDTO();
		p.setNombreUsuario("RobertoM");
        p.setMail("robert@hotmail.com");
        p.setPassword("Chinchulin");
        p.setNombre("Roberto Magan");
        p.setDomicilio("Avenida Independencia 552");
        p.setDni(4523664);
        p.setFechaNacimiento("20/02/1993");
        p.setRolUsuario("Administrador");
		datos.add(p);
	}*/
	public void grabar() {
		//File archivo = new File("pacientes.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datos);
		//grabo el String
		try{
			//Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fileWriter = new FileWriter("practicas.txt");
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();		
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	 private List<PracticaDTO> leer() {
	    	ArrayList<PracticaDTO> practicas = new ArrayList<>();
	        String cadena;
	        
	            FileReader f;
	    		try {
	    			f = new FileReader("practicas.txt");
	    	        BufferedReader b = new BufferedReader(f);
	    	        cadena = b.readLine();
	    	        System.out.println(cadena);
	    	        JsonParser parser = new JsonParser();
	    	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
	    	        Gson g = new Gson();
	    	        for(JsonElement js : gsonArr)
	    	        	practicas.add(g.fromJson(js, PracticaDTO.class));
	    	        	b.close();
	    	        	return practicas;
	    		} catch (IOException e) {

	    			e.printStackTrace();
	    		}
	        
			return practicas;	
	    }
}
