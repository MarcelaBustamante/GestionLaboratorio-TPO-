package view.tablemodel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import collections.PeticionCollection;
import dto.PeticionDTO;

public class PeticionTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<PeticionDTO> listaPeticiones;
	
	protected String[] columnNames = new String[] { "ID", "Sucursal", "Nombre del paciente", "Obra social", "Fecha inicio", "Practica", "Fecha Entrega"}; 
	protected Class[] columnClasses = new Class[] { int.class, int.class, String.class, String.class, String.class, String.class,String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PeticionTableModel(PeticionCollection listpeticion)
	{
		listaPeticiones = listpeticion.getPeticionesList();
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return listaPeticiones.size();
	}
	
    @Override
    public boolean isCellEditable(int row, int column)
    {
    	return false;
    }
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) 
		{ 
			case 0: return listaPeticiones.get(rowIndex).getIdPeticion(); 
			case 1: return listaPeticiones.get(rowIndex).getIdSucursal();
			case 2: return listaPeticiones.get(rowIndex).getUnPaciente();
			case 3: return listaPeticiones.get(rowIndex).getObraSocial();
			case 4: return listaPeticiones.get(rowIndex).getFechaCarga();
			case 5: return listaPeticiones.get(rowIndex).getPracticaAsociada();
			case 6: return listaPeticiones.get(rowIndex).getFechaEntrega();
			default: return null; 
		}
	}
	
	public void agregar(PeticionDTO peticion)
	{
		listaPeticiones.add(peticion);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		listaPeticiones.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(PeticionDTO peticion)
	{
		eliminar(listaPeticiones.indexOf(peticion));
	}	

}
