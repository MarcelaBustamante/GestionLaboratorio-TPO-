package dto;

import model.TipoValorCritico;

public class ResultadoPeticionDTO {
	private int id;
	private String valorCriticos;
	private TipoValorCritico tipoValCri;
	
	
	public ResultadoPeticionDTO(int id,String valorCriticos) {
		this.id = id;
		this.valorCriticos = valorCriticos;
		tipoValCri = TipoValorCritico.Normal ;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the valorCriticos
	 */
	public String getValorCriticos() {
		return valorCriticos;
	}
	/**
	 * @param valorCriticos the valorCriticos to set
	 */
	public void setValorCriticos(String valorCriticos) {
		this.valorCriticos = valorCriticos;
	}
	/**
	 * @return the tipoValCri
	 */
	public TipoValorCritico getTipoValCri() {
		return tipoValCri;
	}
	/**
	 * @param tipoValCri the tipoValCri to set
	 */
	public void setTipoValCri(TipoValorCritico tipoValCri) {
		this.tipoValCri = tipoValCri;
	}
	
}
