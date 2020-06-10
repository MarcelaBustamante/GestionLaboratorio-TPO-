package collections;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import dto.PeticionDTO;



public class PeticionCollection {
private List<PeticionDTO> datos;
	
	public PeticionCollection()
	{
		 // addDemoData();
		 datos = leer();
		
	}
	
	public List<PeticionDTO> getPeticionesList()
	{
		return datos;
	}
	
	public PeticionDTO getPeticion(int index)
	{
		return datos.get(index);
	}
	
	public void agregarDatos(PeticionDTO peticion) {
		datos.add(peticion);
	}
	
	public void addDemoData(){ 
		PeticionDTO p = new PeticionDTO();
		p.setIdPeticion(1);
		p.setIdSucursal(1);
		p.setDniPaciente(94472131);
		p.setObraSocial("OSDE");
		datos.add(p);
	}
	
	public void grabar() {
		String nombreArchivo = "peticiones.txt";
		try {
			FileUtils.grabar(nombreArchivo, datos);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
    private List<PeticionDTO> leer() {
    	String nombreArchivo = "peticiones.txt";
		try {
			datos = FileUtils.leer(nombreArchivo, PeticionDTO.class);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return datos;
    }

}
