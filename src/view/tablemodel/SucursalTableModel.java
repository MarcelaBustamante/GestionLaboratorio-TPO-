package view.tablemodel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import collections.SucursalCollection;
import dto.SucursalDTO;
import model.EstadoSucursal;


public class SucursalTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<SucursalDTO> listaSucursales;	
	protected String[] columnNames = new String[] { "id Sucursal", "Estado", "Direccion", "Responsable técnico"}; 
	protected Class[] columnClasses = new Class[] { int.class,EstadoSucursal.class,String.class,String.class}; 

	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public SucursalTableModel(List<SucursalDTO> listsucursales)
	{
		listaSucursales = listsucursales;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return listaSucursales.size();
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
		case 0: return listaSucursales.get(rowIndex).getIdSucursal(); 
		case 1: return listaSucursales.get(rowIndex).getEstado();
		case 2: return listaSucursales.get(rowIndex).getDireccion();
		case 3: return listaSucursales.get(rowIndex).getResponsableTecnico();
			default: return null; 
		}
	}
	
	public void agregar(SucursalDTO sucursal)
	{
		listaSucursales.add(sucursal);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		listaSucursales.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(SucursalDTO sucursal)
	{
		eliminar(listaSucursales.indexOf(sucursal));
	}	

}
