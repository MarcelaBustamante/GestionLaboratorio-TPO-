package dto;

import java.util.Date;

import model.EstadoPeticion;
import model.Practica;

public class PeticionDTO {
	private int idPeticion;
	private int idSucursal;
	private String unPaciente;
	private String obraSocial;
	private String fechaCarga;
	private String practicaAsociada;
	private String fechaEntrega;
	private EstadoPeticion estado;
	
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
	 * @return the unPaciente
	 */
	public String getUnPaciente() {
		return unPaciente;
	}
	/**
	 * @param unPaciente the unPaciente to set
	 */
	public void setUnPaciente(String unPaciente) {
		this.unPaciente = unPaciente;
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
	public String getFechaCarga() {
		return fechaCarga;
	}
	/**
	 * @param fechaCarga the fechaCarga to set
	 */
	public void setFechaCarga(String fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	/**
	 * @return the practicaAsociada
	 */
	public String getPracticaAsociada() {
		return practicaAsociada;
	}
	/**
	 * @param practicaAsociada the practicaAsociada to set
	 */
	public void setPracticaAsociada(String practicaAsociada) {
		this.practicaAsociada = practicaAsociada;
	}
	/**
	 * @return the fechaEntrega
	 */
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(String fechaEntrega) {
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
	
		
	
}
