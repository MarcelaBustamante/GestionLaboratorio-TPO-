package view.tablemodel;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dto.PeticionDTO;

public class PeticionTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<PeticionDTO> listaPeticiones;
	
	protected String[] columnNames = new String[] { "ID", "Sucursal", "DNI", "Obra social", "Fecha inicio", "Practica", "Fecha Entrega","Estado"}; 
	protected Class[] columnClasses = new Class[] { int.class, int.class, int.class, String.class, String.class, int.class,String.class,String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PeticionTableModel(List<PeticionDTO> listpeticion)
	{
		listaPeticiones = listpeticion;
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
			case 2: return listaPeticiones.get(rowIndex).getDniPaciente();
			case 3: return listaPeticiones.get(rowIndex).getObraSocial();
			case 4: return listaPeticiones.get(rowIndex).getFechaCarga();
			case 5: return listaPeticiones.get(rowIndex).getPracticaAsociada();
			case 6: return listaPeticiones.get(rowIndex).getFechaEntrega();
			case 7: return listaPeticiones.get(rowIndex).getEstado().toString();
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
	/**
	 * @return the listaPeticiones
	 */
	public List<PeticionDTO> getListaPeticiones() {
		return listaPeticiones;
	}
	/**
	 * @param listaPeticiones the listaPeticiones to set
	 */
	public void setListaPeticiones(List<PeticionDTO> listaPeticiones) {
		this.listaPeticiones = listaPeticiones;
		this.refresh();
	}	

	
}
