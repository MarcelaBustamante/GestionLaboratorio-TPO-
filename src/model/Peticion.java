package model;

import java.util.Date;
import java.util.List;

public class Peticion {

	private int idPeticion;
	private int idSucursal;
	private int dni;
	private List resultadosPeticion;
	/**
	 * @return the resultadosPeticion
	 */
	public List getResultadosPeticion() {
		return resultadosPeticion;
	}
	/**
	 * @param resultadosPeticion the resultadosPeticion to set
	 */
	public void setResultadosPeticion(List resultadosPeticion) {
		this.resultadosPeticion = resultadosPeticion;
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
	/**
	 * @return the idSucursal
	 */
	public int getIdSucursal() {
		return idSucursal;
	}
	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}
	/**
	 * @return the obraSocial
	 */
	public String getObraSocial() {
		return obraSocial;
	}
	/**
	 * @param obraSocial the obraSocial to set
	 */
	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	/**
	 * @return the fechaCarga
	 */
	public Date getFechaCarga() {
		return fechaCarga;
	}
	/**
	 * @param fechaCarga the fechaCarga to set
	 */
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	/**
	 * @return the practicaAsociada
	 */
	public Practica getPracticaAsociada() {
		return practicaAsociada;
	}
	/**
	 * @param practicaAsociada the practicaAsociada to set
	 */
	public void setPracticaAsociada(Practica practicaAsociada) {
		this.practicaAsociada = practicaAsociada;
	}
	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	/**
	 * @return the estado
	 */
	public EstadoPeticion getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoPeticion estado) {
		this.estado = estado;
	}
	private String obraSocial;
	private Date fechaCarga;
	private Practica practicaAsociada;
	private Date fechaEntrega;
	private EstadoPeticion estado;

}
