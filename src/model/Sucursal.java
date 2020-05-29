package model;


public class Sucursal {
	private int idSucursal;
	private String direccion;
	private String responsableTecnico;
	private EstadoSucursal estado;
	
	//Getters and setters
	
	public EstadoSucursal getEstado() {
		return estado;
	}
	public void setEstado(EstadoSucursal estado) {
		this.estado = estado;
	}
	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getResponsableTecnico() {
		return responsableTecnico;
	}
	public void setResponsableTecnico(String responsableTecnico) {
		this.responsableTecnico = responsableTecnico;
	}
	
	
	public Sucursal (int idSucursal, String direccion, String responsableTecnico)
	{
		this.idSucursal = idSucursal;
		this.direccion = direccion;
		this.responsableTecnico = responsableTecnico;
		this.estado=EstadoSucursal.Activa;
	}
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}

	


}
