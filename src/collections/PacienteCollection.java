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
import com.sun.xml.internal.bind.v2.model.core.ID;

import dto.PacienteDTO;
import dto.PeticionDTO;

public class PacienteCollection {
	private List<PacienteDTO> datos;

	public PacienteCollection() {
		datos = leer();

	}

	public List<PacienteDTO> getPacientesList() {
		return datos;
	}

	public PacienteDTO getPaciente(int index) {
		return datos.get(index);
	}
	public PacienteDTO getPacienteId(int id) {
		for (PacienteDTO pacienteDTO : datos) {
			if(id == pacienteDTO.getIdPaciente()) {
				return pacienteDTO;
			}
		}
		return null;
	}

	public void agregarDatos(PacienteDTO paciente) {
		PacienteDTO p = getPacienteId(paciente.getIdPaciente());
		if(p != null) {
			p.setIdPaciente(paciente.getIdPaciente());
			p.setDni(paciente.getDni());
			p.setNombre(paciente.getNombre());
			p.setDomicilio(paciente.getDomicilio());
			p.setMail(paciente.getMail());
			p.setSexo(paciente.getSexo());
			p.setEdad(paciente.getEdad());
		
		}else {
			datos.add(paciente);
		}
	}
	public void grabar() {
		try {
			FileUtils.grabar("pacientes.txt", datos);
		} catch (Exception ex) {
			datos = new ArrayList<>();
			System.out.println(ex.getMessage());
		}
	}

	private List<PacienteDTO> leer() {
		try {
			datos = FileUtils.leer("pacientes.txt", PacienteDTO.class);
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
