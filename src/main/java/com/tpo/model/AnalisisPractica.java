package com.tpo.model;

public class AnalisisPractica {
private Practica unaPractica;	
private String descripcion;
private EstadoAnalisisPractica estado = EstadoAnalisisPractica.NUEVO ;

//este es para asaber si posee valores criticos o reservados pero no se
//que tipo deber�a de ir ahi

private boolean valoresCriticos;
private boolean valoresReservados;


public boolean estado() {
	System.out.println("para saber en que estado se encuentra la practica");
	return true;
}
}
