package collections;

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

import dto.PeticionDTO;

public class PeticionCollection {
	private List<PeticionDTO> datos;

	public PeticionCollection() {
		datos = leer();

	}

	public List<PeticionDTO> getPeticionesList() {
		return datos;
	}

	public PeticionDTO getPeticion(int index) {
		return datos.get(index);
	}

	public void agregarDatos(PeticionDTO peticion) {
		datos.add(peticion);
	}

	public void grabar() {
		try {
			FileUtils.grabar("peticiones.txt", datos);
		} catch (Exception ex) {
			datos = new ArrayList<>();
			System.out.println(ex.getMessage());
		}
	}

	private List<PeticionDTO> leer() {
		try {
			datos = FileUtils.leer("peticiones.txt", PeticionDTO.class);
		}catch (Exception e) {
			//si no existe el archivo lo crea 
			datos = new ArrayList<>();
			System.out.println(e.getMessage());
		}
		return datos;
	}

	public void eliminar(int id) {
		datos.remove(id);
		grabar();
	}
	
}
