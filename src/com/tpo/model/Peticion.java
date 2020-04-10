package com.tpo.model;

import java.time.LocalDate;

public class Peticion {
	
private Paciente unPaciente;
private String obraSocial;
private LocalDate fechaCarga;
private Practica practicaAsociada;


public void peticionCompleta() {
	
}


public Paciente getUnPaciente() {
	return unPaciente;
}


public void setUnPaciente(Paciente unPaciente) {
	this.unPaciente = unPaciente;
}


public String getObraSocial() {
	return obraSocial;
}


public void setObraSocial(String obraSocial) {
	this.obraSocial = obraSocial;
}


public LocalDate getFechaCarga() {
	return fechaCarga;
}


public void setFechaCarga(LocalDate fechaCarga) {
	this.fechaCarga = fechaCarga;
}


public Practica getPracticaAsociada() {
	return practicaAsociada;
}


public void setPracticaAsociada(Practica practicaAsociada) {
	this.practicaAsociada = practicaAsociada;
}

}
