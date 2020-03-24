package com.tpo.model;

public class AnalisisPractica {
private Practica unaPractica;	
private String descripcion;
private EstadoAnalisisPractica estado = EstadoAnalisisPractica.NEW ;

//este es para asaber si posee valores criticos o reservados pero no se
//que tipo debería de ir ahi

private boolean valoresCriticos;
private boolean valoresReservados;


public boolean estado() {
	System.out.println("para saber en que estado se encuentra la practica");
	return true;
}
}
