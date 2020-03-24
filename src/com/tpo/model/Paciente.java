package com.tpo.model;

public class Paciente {
	private int dni;
	private String nombre;
	private String url;
	private String sexo;
	private int edad;
	
	
	public boolean consultarPeticion() {
		System.out.println("Este metodo devolvería si la peticion se finalizo");
		return true;
	}

}
