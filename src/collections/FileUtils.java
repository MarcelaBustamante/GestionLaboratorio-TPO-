package collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class FileUtils {

	public static <T> List<T> leer(String nombreArchivo, Class<T> tipo) throws IOException {
		File archivo = new File(nombreArchivo);

		try (FileReader fr = new FileReader(archivo); BufferedReader reader = new BufferedReader(fr);) {
			// leo primer línea para obtener el json
			String json = reader.readLine();
			// parseo el json obtenido a un JsonArray (estructura genérica que representa un
			// array json)
			JsonArray array = (JsonArray) new JsonParser().parse(json);

			Gson gson = new Gson();
			List<T> resultado = new ArrayList<>();
			// itero el array pasando cada JsonElement (elementos del array) al tipo que
			// quiero
			for (JsonElement el : array) {
				resultado.add(gson.fromJson(el, tipo));
			}
			return resultado;
		} catch (IOException e) {
			System.out.println("Error leyendo archivo " + nombreArchivo + ": " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Guarda el contenido en un archivo
	 * 
	 * @param nombreArchivo
	 * @param contenido
	 * @throws IOException 
	 */
	public static void grabar(String nombreArchivo, Object contenido) throws IOException {
		File archivo = new File(nombreArchivo);
		try (FileWriter fileWriter = new FileWriter(archivo); BufferedWriter writer = new BufferedWriter(fileWriter);) {
			// paso el contenido a json y lo guardo a archivo
			String json = new Gson().toJson(contenido);
			writer.write(json);
		} catch (IOException e) {
			System.out.println("Error grabando archivo " + nombreArchivo + ": " + e.getMessage());
			throw e;
		}
	}
	
	/**
	 * Metodo para validar si una fecha en string es válida
	 * @param fecha
	 * @return boolean
	 */
	public static boolean validarFecha(String fecha) {
	    boolean correcto = false;

	    try {
	        //Formato de fecha (día/mes/año)
	        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	        formatoFecha.setLenient(false);
	        //Comprobación de la fecha
	        formatoFecha.parse(fecha);
	        correcto = true;
	    } catch (ParseException e) {
	       System.out.println(e.getMessage());
	        correcto = false;
	    }

	    return correcto;
	}
	
}
