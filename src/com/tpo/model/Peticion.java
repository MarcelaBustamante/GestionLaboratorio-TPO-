package com.tpo.model;

import java.time.LocalDate;

public class Peticion {
	
private int idPeticion;
private Paciente unPaciente;
private String obraSocial;
private LocalDate fechaCarga;
private Practica practicaAsociada;
private EstadoPeticiones estado = EstadoPeticiones.NUEVO;

/**
 * Lista de resultados de peticion se considera completa cuando tiene resultados
 * @return
 */
public Paciente getUnPaciente() {
	return unPaciente;
}


/**
 * @return the idPeticion
 */
public int getIdPeticion() {
	return idPeticion;
}


/**
 * @param idPeticion the idPeticion to set
 */
public void setIdPeticion(int idPeticion) {
	this.idPeticion = idPeticion;
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


/**
 * @return the estado
 */
public EstadoPeticiones getEstado() {
	return estado;
}	


/**
 * En el momento que se cree un resultado para esta peticion se le setea el estado completo
 * @param estado que setea en que estado se encuentra la Peticion para saber si esta completa
 */
public void setEstado(EstadoPeticiones estado) {
	this.estado = estado;
}

public boolean peticionCompleta() {
	return estado == EstadoPeticiones.COMPLETO;
}

}
