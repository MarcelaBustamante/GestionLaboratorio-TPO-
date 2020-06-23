package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controller.PeticionesController;
import dto.PeticionDTO;
import dto.ResultadoPeticionDTO;
import model.EstadoPeticion;
import model.TipoValorCritico;
import view.tablemodel.ResultadoTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Component;

public class ResultadoPeticionview1 extends JFrame {

	private final JPanel contentPane = new JPanel();
	private PeticionDTO peticion = new PeticionDTO();
	private PeticionesController controladorPeticiones = new PeticionesController();
	private ModalResult modalResult;
	private JTextField textValorCritico;
	private ResultadoTableModel tableModel;
	private JComboBox comboBox;
	private JTable table;

	public ResultadoPeticionview1(JFrame frame, PeticionDTO p, PeticionesController peticiones) {
		// super(frame, "Peticion", true);
		setLocationRelativeTo(frame);
		controladorPeticiones = peticiones;
		peticion = p;
		tableModel = new ResultadoTableModel(peticion.getResultados());
		inicializar();

	}
	protected void finalizarLaPeticion() {
		controladorPeticiones.cerrarPeticion(peticion);
	}
	public void setPeticion(PeticionDTO obtenerPeticion) {
		this.peticion = obtenerPeticion;

	}

	public ModalResult getModalResult() {
		return modalResult;
	}

	public void asignarDatosEntidad() {
		ResultadoPeticionDTO result = new ResultadoPeticionDTO(peticion.getResultados().size() + 1,
				textValorCritico.getText());
		result.setTipoValCri((TipoValorCritico) comboBox.getItemAt(comboBox.getSelectedIndex()));
		peticion.agregarResultado(result);
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
		setBounds(100, 100, 500, 389);
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
				JOptionPane.showMessageDialog(null, "Usted no tiene permiso para acceder");
			}
		});
		JLabel lblNewLabel = new JLabel("Agregar un resultado");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));

		JSplitPane splitPane = new JSplitPane();

		JPanel panel_1 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblTIpoValor)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(comboBox,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblValorCritico)
												.addGap(18).addComponent(textValorCritico))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 71,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
						.addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING, false).addComponent(panel_1,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(splitPane))
						.addGap(18)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
								.createSequentialGroup().addContainerGap().addComponent(lblNewLabel).addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblValorCritico)
										.addComponent(textValorCritico, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblTIpoValor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup().addGap(17).addComponent(panel_1,
										GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btnAgregar)
										.addComponent(btnEliminar)))
						.addContainerGap()));

		JButton btnNewButton = new JButton("Finalizar peticion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarLaPeticion();
				modalResult = ModalResult.OK;
				dispose();
			}
		});
		splitPane.setLeftComponent(btnNewButton);

		JButton btnNewButton_1 = new JButton("Rechazar peticion");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Usted no tiene permiso para acceder");
			}
		});
		splitPane.setRightComponent(btnNewButton_1);
		panel_1.setLayout(null);

		JTextArea txtrLuegoDeFinalizar = new JTextArea();
		txtrLuegoDeFinalizar.setWrapStyleWord(true);
		txtrLuegoDeFinalizar.setVerifyInputWhenFocusTarget(false);
		txtrLuegoDeFinalizar.setBounds(0, 5, 236, 80);
		txtrLuegoDeFinalizar.setLineWrap(true);
		txtrLuegoDeFinalizar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		txtrLuegoDeFinalizar.setText("Luego de finalizar la carga de Resultados, finalice la peticion.");
		panel_1.add(txtrLuegoDeFinalizar);
		panel.setLayout(gl_panel);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE).addGap(7)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);

	}
}
