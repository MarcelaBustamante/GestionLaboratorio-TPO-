package controller;

import collections.PacienteCollection;
import dto.PacienteDTO;

public class PacienteController {
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
	
}

