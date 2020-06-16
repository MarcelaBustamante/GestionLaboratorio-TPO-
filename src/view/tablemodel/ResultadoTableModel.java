package view.tablemodel;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dto.PeticionDTO;
import dto.ResultadoPeticionDTO;

public class ResultadoTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ResultadoPeticionDTO> listaResultadoPeticion;
	
	protected String[] columnNames = new String[] { "ID", "Valor Critico", "Tipo de valor critico"}; 
	protected Class[] columnClasses = new Class[] { int.class, String.class, String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public ResultadoTableModel(List<ResultadoPeticionDTO> listResPeticion)
	{
		listaResultadoPeticion = listResPeticion;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return listaResultadoPeticion.size();
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
			case 0: return listaResultadoPeticion.get(rowIndex).getId();
			case 1: return listaResultadoPeticion.get(rowIndex).getValorCriticos();
			case 2: return listaResultadoPeticion.get(rowIndex).getTipoValCri().toString();
			default: return null; 
		}
	}
	
	public void agregar(ResultadoPeticionDTO ResPeticion)
	{
		listaResultadoPeticion.add(ResPeticion);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		listaResultadoPeticion.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(ResultadoPeticionDTO ResPeticion)
	{
		eliminar(listaResultadoPeticion.indexOf(ResPeticion));
	}
	/**
	 * @return the listaPeticiones
	 */
	public List<ResultadoPeticionDTO> getListaResPeticiones() {
		return listaResultadoPeticion;
	}
	/**
	 * @param listaResPeticiones the listaPeticiones to set
	 */
	public void setListaResPeticiones(List<ResultadoPeticionDTO> listaResPeticiones) {
		this.listaResultadoPeticion = listaResPeticiones;
		this.refresh();
	}	

	
}
