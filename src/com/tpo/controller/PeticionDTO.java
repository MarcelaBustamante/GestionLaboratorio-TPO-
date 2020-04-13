package com.tpo.controller;

import java.sql.Date;

import com.tpo.model.Paciente;
import com.tpo.model.Practica;

public class PeticionDTO {
	
	private Paciente paciente;
	private String obraSocial;
	private Date fechaCargada;
	private Practica practicaAsociada;
	private String estado;
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	public Date getFechaCargada() {
		return fechaCargada;
	}
	public void setFechaCargada(Date fechaCargada) {
		this.fechaCargada = fechaCargada;
	}
	public Practica getPracticaAsociada() {
		return practicaAsociada;
	}
	public void setPracticaAsociada(Practica practicaAsociada) {
		this.practicaAsociada = practicaAsociada;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
