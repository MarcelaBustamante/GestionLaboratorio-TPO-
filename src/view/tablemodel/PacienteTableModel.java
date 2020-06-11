package view.tablemodel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Controller.PacienteController;
import collections.PacienteCollection;
import dto.PacienteDTO;

public class PacienteTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<PacienteDTO> listaPacientes;
	
	protected String[] columnNames = new String[] { "ID", "Dni", "Nombre", "Domicilio", "Mail", "Sexo", "Edad"}; 
	protected Class[] columnClasses = new Class[] { int.class, int.class, String.class, String.class, String.class, String.class,int.class}; 

	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PacienteTableModel(PacienteCollection listpaciente)
	{
		listaPacientes = listpaciente.getPacientesList();
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return listaPacientes.size();
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
			case 0: return listaPacientes.get(rowIndex).getIdPaciente(); 
			case 1: return listaPacientes.get(rowIndex).getDni();
			case 2: return listaPacientes.get(rowIndex).getNombre();
			case 3: return listaPacientes.get(rowIndex).getDomicilio();
			case 4: return listaPacientes.get(rowIndex).getMail();
			case 5: return listaPacientes.get(rowIndex).getSexo();
			case 6: return listaPacientes.get(rowIndex).getEdad();
			default: return null; 
		}
	}
	
	public void agregar(PacienteDTO paciente)
	{
		listaPacientes.add(paciente);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		listaPacientes.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(PacienteDTO paciente)
	{
		eliminar(listaPacientes.indexOf(paciente));
	}	

}
