package model;
import java.util.Date;


public class Peticion {
	
	private int idPeticion;
	private int idSucursal;
	private String unPaciente;
	private String obraSocial;
	private Date fechaCarga;
	private Practica practicaAsociada;
	private Date fechaEntrega;
	private EstadoPeticion estado;
	
	//Getter and setters
	public int getIdPeticion() {
		return idPeticion;
	}
	public void setIdPeticion(int idPeticion) {
		this.idPeticion = idPeticion;
	}
	public String getUnPaciente() {
		return unPaciente;
	}
	public void setUnPaciente(String unPaciente) {
		this.unPaciente = unPaciente;
	}
	public String getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	public Date getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	public Practica getPracticaAsociada() {
		return practicaAsociada;
	}
	public void setPracticaAsociada(Practica practicaAsociada) {
		this.practicaAsociada = practicaAsociada;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public EstadoPeticion getEstado() {
		return estado;
	}
	public void setEstado(EstadoPeticion estado) {
		this.estado = estado;
	}
	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	
	
	
	

}
