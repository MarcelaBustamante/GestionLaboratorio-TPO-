package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import collections.PeticionCollection;
import view.tablemodel.PeticionTableModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class PeticionView extends JFrame {
	private PeticionCollection peticiones;
	private JPanel peticionPanel;
	private JPanel panel_1;
	private JTable tablePeticiones;
	private PeticionTableModel tableModelPeticion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeticionView frame = new PeticionView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PeticionView() {
		peticiones = new PeticionCollection();
		tableModelPeticion = new PeticionTableModel(peticiones);
		inicializar();
	}

	private void inicializar() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}				

		
		setIconImage(Toolkit.getDefaultToolkit().getImage(PeticionView.class.getResource("/res/hospital4.png")));
		setTitle("ABM Peticiones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 671, 542);
		peticionPanel = new JPanel();
		peticionPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(peticionPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		panel_1 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_peticionPanel = new GroupLayout(peticionPanel);
		gl_peticionPanel.setHorizontalGroup(
			gl_peticionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_peticionPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
		);
		gl_peticionPanel.setVerticalGroup(
			gl_peticionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_peticionPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
		);
		
		tablePeticiones = new JTable(tableModelPeticion);
		tablePeticiones.setAutoCreateRowSorter(true);
		tablePeticiones.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setColumnHeaderView(tablePeticiones);
		
		JButton btnAgregar = new JButton("Agregar");
		
		JButton btnModificar = new JButton("Modificar");
		
		JButton btnEliminar = new JButton("Eliminar");
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnAgregar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnModificar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEliminar))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(15)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminar)
						.addComponent(btnModificar)
						.addComponent(btnAgregar))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPeticiones = new JLabel("ABM Peticiones");
		panel.add(lblPeticiones);
		lblPeticiones.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblPeticiones.setBackground(SystemColor.desktop);
		peticionPanel.setLayout(gl_peticionPanel);
		
	}
	
}
