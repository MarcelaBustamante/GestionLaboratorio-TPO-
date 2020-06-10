package dto;

import java.util.Date;

public class PracticaDTO {
	
	private String codigoPractica;
	private String nombrePractica;
	private String grupo;
	private String valoresCriticos;
	private String valoresReservados;
	private String date;
	
	public PracticaDTO(String codigoPractica, String nombrePractica, String grupo, String d,
			String e, String date) {
		super();
		this.codigoPractica = codigoPractica;
		this.nombrePractica = nombrePractica;
		this.grupo = grupo;
		this.valoresCriticos = d;
		this.valoresReservados = e;
		this.date = date;
	}
	
	public PracticaDTO() {
		
	}

	public String getCodigoPractica() {
		return codigoPractica;
	}

	public void setCodigoPractica(String codigoPractica) {
		System.out.print(codigoPractica);
		this.codigoPractica = codigoPractica;
	}

	public String getNombrePractica() {
		return nombrePractica;
	}

	public void setNombrePractica(String nombrePractica) {
		this.nombrePractica = nombrePractica;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getValoresCriticos() {
		return valoresCriticos;
	}

	public void setValoresCriticos(String valoresCriticos) {
		this.valoresCriticos = valoresCriticos;
	}

	public String getValoresReservados() {
		return valoresReservados;
	}

	public void setValoresReservados(String valoresReservados) {
		this.valoresReservados = valoresReservados;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	

}
