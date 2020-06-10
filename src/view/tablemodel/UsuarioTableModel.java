package view.tablemodel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import collections.UsuarioCollection;
import dto.UsuarioDTO;


public class UsuarioTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<UsuarioDTO> listaUsuarios;
	
	protected String[] columnNames = new String[] { "Nombre de usuario", "Mail", "Contraseña", "Nombre del paciente","Direccion", "Dni", "Fecha de nacimiento","Rol"}; 
	protected Class[] columnClasses = new Class[] { String.class,String.class,String.class,String.class,String.class,int.class, String.class,String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public UsuarioTableModel(UsuarioCollection listusuario)
	{
		listaUsuarios = listusuario.getUsuariosList();
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return listaUsuarios.size();
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
			case 0: return listaUsuarios.get(rowIndex).getNombreUsuario(); 
			case 1: return listaUsuarios.get(rowIndex).getMail();
			case 2: return listaUsuarios.get(rowIndex).getPassword();
			case 3: return listaUsuarios.get(rowIndex).getNombre();
			case 4: return listaUsuarios.get(rowIndex).getDomicilio();
			case 5: return listaUsuarios.get(rowIndex).getDni();
			case 6: return listaUsuarios.get(rowIndex).getFechaNacimiento();
			case 7: return listaUsuarios.get(rowIndex).getRol();
			default: return null; 
		}
	}
	
	public void agregar(UsuarioDTO usuario)
	{
		listaUsuarios.add(usuario);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		listaUsuarios.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(UsuarioDTO usuario)
	{
		eliminar(listaUsuarios.indexOf(usuario));
	}	

}
