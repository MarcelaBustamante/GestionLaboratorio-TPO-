package collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import dto.PeticionDTO;
import dto.PracticaDTO;
import dto.UsuarioDTO;

public class PracticaCollection {
	private List<PracticaDTO> datos;
	public PracticaCollection()
	{
		
		datos = leer();
	}
	public List<PracticaDTO> getPracticaList()
	{
		return datos;
	}
	
	public PracticaDTO getPracticaId(int id) {
		for (PracticaDTO practicaDTO : datos) {
			if(id == practicaDTO.getCodigoPractica()) {
				return practicaDTO;
			}
		}
		return null;
	}
	
	public PracticaDTO getPractica(int index)
	{
		return datos.get(index);
	}
	
	public void agregarDatos(PracticaDTO practica) {
		PracticaDTO p = getPracticaId(practica.getCodigoPractica());
		if(p != null) {
			p.setActivo(practica.isActivo());
			p.setDate(practica.getDate());
			p.setGrupo(practica.getGrupo());
			p.setNombrePractica(practica.getNombrePractica());
			p.setValoresCriticos(practica.getValoresCriticos());
			p.setValoresReservados(practica.getValoresReservados());
		
		}else {
			datos.add(practica);
		}
	}
	
	public void grabar() {
		try {
			FileUtils.grabar("practicas.txt", datos);
		} catch (Exception ex) {
			datos = new ArrayList<>();
			System.out.println(ex.getMessage());
		}
	}
	 private List<PracticaDTO> leer() {
		 try {
				datos = FileUtils.leer("practicas.txt", PracticaDTO.class);
			}catch (Exception e) {
				//si no existe el archivo lo crea 
				datos = new ArrayList<>();
				System.out.println(e.getMessage());
			}
			return datos;
	 }
	 
	 public void eliminar(int pos) {
		 PracticaDTO p = getPractica(pos);
		 	p.setActivo(false);
		 	this.agregarDatos(p);
			this.grabar();
		}
	 
	 
}
