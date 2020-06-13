package dto;
import model.EstadoSucursal;

public class SucursalDTO {
	private int idSucursal;
	private String direccion;
	private String responsableTecnico;
	private EstadoSucursal estado;
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
	public EstadoSucursal getEstado() {
		return estado;
	}
	public void setEstado(EstadoSucursal estado) {
		this.estado = estado;
	}
	
	
}
