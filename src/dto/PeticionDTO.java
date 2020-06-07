package dto;

import java.util.Date;

import model.EstadoPeticion;
import model.Paciente;
import model.Practica;

public class PeticionDTO {
	private int idPeticion;
	private int idSucursal;
	private Paciente unPaciente;
	private String obraSocial;
	private String fechaCarga;
	private Practica practicaAsociada;
	private String fechaEntrega;
	private EstadoPeticion estado;
	
	public PeticionDTO( int idPeticion,int idSucursal, Paciente unPaciente,
						String obraSocial, String fechaCarga, Practica practicaAsociada,
						String fechaEntrega,
						EstadoPeticion estado){
		this.idPeticion = idPeticion;
		this.idSucursal = idSucursal;
		this.unPaciente = unPaciente;
		this.obraSocial = obraSocial;
		this.fechaCarga = fechaCarga;
		this.practicaAsociada = practicaAsociada;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
	};
	
	
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
	public Paciente getUnPaciente() {
		return unPaciente;
	}
	/**
	 * @param unPaciente the unPaciente to set
	 */
	public void setUnPaciente(Paciente unPaciente) {
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
