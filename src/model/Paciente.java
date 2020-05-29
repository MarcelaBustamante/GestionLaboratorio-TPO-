package model;

public class Paciente {
	private int dniPaciente;
	private String nombre;
	private String domicilio;
	private String mail;
	
	//Getter and setters
	public int getDniPaciente() {
		return dniPaciente;
	}
	public void setDniPaciente(int dniPaciente) {
		this.dniPaciente = dniPaciente;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	private String sexo;
	private int edad;
	
	
	//Funciones extras
	
	
	
	

}
