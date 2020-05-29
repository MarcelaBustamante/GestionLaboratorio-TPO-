package model;

public class Practica {
	private int codPractica;
	private String nombrePractica;
	private int horasResultado;
	private EstadoPractica estado;
	
	//Getters and Setters
	public int getCodPractica() {
		return codPractica;
	}
	public void setCodPractica(int codPractica) {
		this.codPractica = codPractica;
	}
	public String getNombrePractica() {
		return nombrePractica;
	}
	public void setNombrePractica(String nombrePractica) {
		this.nombrePractica = nombrePractica;
	}
	public int getHorasResultado() {
		return horasResultado;
	}
	public void setHorasResultado(int horasResultado) {
		this.horasResultado = horasResultado;
	}
	public EstadoPractica getEstado() {
		return estado;
	}
	public void setEstado(EstadoPractica estado) {
		this.estado = estado;
	}
	
	

}
