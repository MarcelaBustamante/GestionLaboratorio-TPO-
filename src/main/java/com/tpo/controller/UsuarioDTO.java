package com.tpo.controller;

public class UsuarioDTO {
	public enum UserRol {recepción,laboratorista,administrador};//Defino enum con los roles
	private UserRol rolusuario;
	private int    idUsuario;
	private String usuario;
	private String email;
	private String nombre;
	private String domicilio;
	private int    dni;
	
	public UserRol getRolusuario() {
		return rolusuario;
	}
	public void setRolusuario(UserRol rolusuario) {
		this.rolusuario = rolusuario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}

}
