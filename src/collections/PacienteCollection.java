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
import dto.PacienteDTO;
import dto.PeticionDTO;

public class PacienteCollection {
	private List<PacienteDTO> datos = new ArrayList<>();
	public PacienteCollection()
	{
		addDemoData();
		datos = leer();
	}
	public List<PacienteDTO> getPacientesList()
	{
		return datos;
	}
	
	public PacienteDTO getPaciente(int index)
	{
		return datos.get(index);
	}
	
	public void agregarDatos(PacienteDTO paciente) {
		datos.add(paciente);
	}
	
	public void addDemoData()
	{
		PacienteDTO p = new PacienteDTO();
		p.setIdPaciente(1);
		p.setDni(452658);
		p.setNombre("Julia");
		p.setDomicilio("Avenida Independencia 523");
		p.setMail("july@hotmail.com");
		p.setSexo("Femenino");
		p.setEdad(29);
		datos.add(p);
	}
	public void grabar() {
		try {
			FileUtils.grabar("pacientes.txt", datos);
		} catch (IOException e) {
			datos = new ArrayList<>();
			System.out.println( e.getMessage());
		}
	}
	 private List<PacienteDTO> leer() {

		 try {
				datos = FileUtils.leer("pacientes.txt", PacienteDTO.class);
			} catch (IOException e) {
				datos = new ArrayList<>();
				System.out.println( e.getMessage());
			}
			return datos;
	    }
}
