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
import dto.UsuarioDTO;

public class UsuarioCollection {
	private List<UsuarioDTO> datos = new ArrayList<>();
	public UsuarioCollection()
	{
		addDemoData();
		datos = leer();
	}
	public List<UsuarioDTO> getUsuariosList()
	{
		return datos;
	}
	
	public UsuarioDTO getUsuario(int index)
	{
		return datos.get(index);
	}
	
	public void agregarDatos(UsuarioDTO usuario) {
		datos.add(usuario);
	}
	
	public void addDemoData()
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
	}
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
			fileWriter = new FileWriter("usuarios.txt");
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();		
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	 private List<UsuarioDTO> leer() {
	    	ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
	        String cadena;
	        
	            FileReader f;
	    		try {
	    			f = new FileReader("usuarios.txt");
	    	        BufferedReader b = new BufferedReader(f);
	    	        cadena = b.readLine();
	    	        System.out.println(cadena);
	    	        JsonParser parser = new JsonParser();
	    	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
	    	        Gson g = new Gson();
	    	        for(JsonElement js : gsonArr)
	    	        	usuarios.add(g.fromJson(js, UsuarioDTO.class));
	    	        	b.close();
	    	        	return usuarios;
	    		} catch (IOException e) {

	    			e.printStackTrace();
	    		}
	        
			return usuarios;	
	    }
}
