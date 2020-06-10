package view.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import collections.PracticaCollection;
import dto.PracticaDTO;

public class PracticaTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<PracticaDTO> lista;
	
	protected String[] columnNames = new String[] { "Codigo", "Nombre", "Grupo", "Val. Criticos", "Val. Reservados", "Cant. Horas"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, String.class, String.class, String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PracticaTableModel(PracticaCollection coleccionPractica)
	{
		lista = coleccionPractica.getPracticaList();
	}
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}
	
    public boolean isCellEditable(int row, int column)
    {
    	return false;
    }
    
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) 
		{ 
			case 0: return lista.get(rowIndex).getCodigoPractica(); 
			case 1: return lista.get(rowIndex).getNombrePractica();
			case 2: return lista.get(rowIndex).getGrupo();
			case 3: return lista.get(rowIndex).getValoresCriticos();
			case 4: return lista.get(rowIndex).getValoresReservados();
			case 5: return lista.get(rowIndex).getDate();
			default: return null; 
		}
	}
	
	public void agregar(PracticaDTO practica)
	{
		lista.add(practica);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		lista.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(PracticaDTO practica)
	{
		eliminar(lista.indexOf(practica));
	}	
}
