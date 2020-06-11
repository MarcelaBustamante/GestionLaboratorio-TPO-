package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import collections.PacienteCollection;
import dto.PacienteDTO;
import view.tablemodel.PacienteTableModel;

public class PacienteController {
	//private List<PacienteDTO> pacientes;
	PacienteDTO paciente;
	PacienteCollection pacienteCollection;
	public PacienteController() {
		paciente = new PacienteDTO();
		pacienteCollection = new PacienteCollection();
	}
	
	public void darDeBaja() {
		
	}
	public PacienteDTO altaPaciente(int id, int dni, String nombre, String domicilio, String mail, String sexo, int edad) {
		
		paciente.setIdPaciente(id);
        paciente.setDni(dni);
        paciente.setNombre(nombre);
        paciente.setDomicilio(domicilio);
        paciente.setMail(mail);
        paciente.setSexo(sexo);
        paciente.setEdad(edad);
        
        pacienteCollection.agregarDatos(paciente);
        pacienteCollection.grabar();
        return paciente;
    }
	
	public PacienteDTO getPacienteDTO() {
		return paciente;
	}
	/*public void ModificacionResultado(PacienteDTO pacient){
		ArrayList<PacienteDTO> list= new ArrayList<>();
		list = (ArrayList<PacienteDTO>) getPacienteDTO();
		
		for (int i = 0; i < list.size(); i++) {
			
		    if (pacient.getDni() == list.get(i).getDni()) {
		    	list.set(i,pacient);
		    }     
		}
		pacienteCollection.agregarDatos(pacient);
		pacienteCollection.grabar();
    }*/
	/*public List<PacienteDTO> getPacientesList() {
		pacienteCollection.getPacientesList();
		return (List<PacienteDTO>) paciente;
	}*/
}

