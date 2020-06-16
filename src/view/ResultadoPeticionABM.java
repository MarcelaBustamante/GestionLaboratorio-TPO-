package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.txw2.TXW;

import controller.PeticionesController;
import dto.PeticionDTO;
import dto.ResultadoPeticionDTO;
import model.TipoValorCritico;
import view.tablemodel.ResultadoTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultadoPeticionABM extends JFrame {

	private final JPanel contentPane = new JPanel();
	private PeticionDTO peticion = new PeticionDTO(); 
	private PeticionesController controladorPeticiones = new PeticionesController();
	private ModalResult modalResult;
	private JTextField textValorCritico;
	private ResultadoTableModel tableModel;
	private JComboBox comboBox;
	private JTable table;


	
	
	public ResultadoPeticionABM(JFrame frame, PeticionDTO p, PeticionesController peticiones) {
		//super(frame, "Peticion", true);
		setLocationRelativeTo(frame);	
		controladorPeticiones = peticiones;
		peticion = p;
		tableModel = new ResultadoTableModel(peticion.getResultados());
		inicializar();
																									
	}

	public void setPeticion(PeticionDTO obtenerPeticion) {
		this.peticion = obtenerPeticion;
		
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
	
	
	public void asignarDatosEntidad() {
		ResultadoPeticionDTO result = new ResultadoPeticionDTO(peticion.getResultados().size() + 1,textValorCritico.getText());
		result.setTipoValCri((TipoValorCritico) comboBox.getItemAt(comboBox.getSelectedIndex()));
		peticion.agregarResultado(result);
		controladorPeticiones.agregarPeticion(peticion);
		tableModel.refresh();
	}
	
	protected void eliminarValorCritico() {
		peticion.eliminarValor(table.getSelectedRow());
		controladorPeticiones.agregarPeticion(peticion);
		tableModel.refresh();
	}
	private void inicializar() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(PeticionABM.class.getResource("/res/hospital4.png")));
		setTitle("ABM Resultado de Peticion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JLabel lblValorCritico = new JLabel("Valor critico");
		
		textValorCritico = new JTextField();
		textValorCritico.setColumns(10);
		
		JLabel lblTIpoValor = new JLabel("Tipo valor cr\u00EDtico");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipoValorCritico.values()));
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignarDatosEntidad();
				modalResult = ModalResult.OK;
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarValorCritico();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblValorCritico)
							.addGap(18)
							.addComponent(textValorCritico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTIpoValor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(btnAgregar)
							.addGap(18)
							.addComponent(btnEliminar)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorCritico)
						.addComponent(textValorCritico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTIpoValor)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAgregar)
							.addComponent(btnEliminar)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
		);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
	}

}
