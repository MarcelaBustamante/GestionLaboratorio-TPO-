package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import collections.PeticionCollection;
import controller.PeticionesController;
import view.tablemodel.PeticionTableModel;
import view.ModalResult;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

//import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PeticionABM extends JFrame {
	private PeticionesController peticiones;

	private JFrame frame;
	private JPanel peticionPanel;
	private JPanel panel_1;
	private JTable tablePeticiones;
	private PeticionTableModel tableModelPeticion;
	private JCheckBox chbxResultadosCriticos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeticionABM window = new PeticionABM();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PeticionABM() {
		peticiones = new PeticionesController();
		tableModelPeticion = new PeticionTableModel(peticiones.listaPeticiones());
		inicializar();
	}

	private void agregarPeticion() {
		try {
			// abre un alta de peticion
			AltaPeticion dialog = new AltaPeticion(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			JOptionPane.showMessageDialog(null, "finalizado");
			if (dialog.getModalResult() == ModalResult.OK)
				tableModelPeticion.agregar(dialog.getPeticion());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modificar() {
		try {
			AltaPeticion dialog = new AltaPeticion(frame);
			dialog.setPeticion(peticiones.obtenerPeticion((tablePeticiones.getSelectedRow())));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				tableModelPeticion.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void eliminar() {
		peticiones.eliminarPeticion(tablePeticiones.getSelectedRow());
		tableModelPeticion.refresh();
	}

	
	private void visualizarCriticos(boolean selected) {
		if(selected) {
			tableModelPeticion.setListaPeticiones(peticiones.listaPeticionesResCriticos());
			
		} else {
			tableModelPeticion.setListaPeticiones(peticiones.listaPeticiones());
			
		}
	}
	private void inicializar() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(PeticionABM.class.getResource("/res/hospital4.png")));
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
		gl_peticionPanel.setHorizontalGroup(gl_peticionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_peticionPanel.createSequentialGroup().addContainerGap()
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE).addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_peticionPanel.createSequentialGroup().addGap(28)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE).addContainerGap()));
		gl_peticionPanel.setVerticalGroup(gl_peticionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_peticionPanel.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
						.addGap(11).addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)));

		tablePeticiones = new JTable(tableModelPeticion);
		tablePeticiones.setAutoCreateRowSorter(true);
		tablePeticiones.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tablePeticiones);

		chbxResultadosCriticos = new JCheckBox("Ver peticiones con resultados criticos");
		chbxResultadosCriticos.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				visualizarCriticos(((JCheckBox) e.getItem()).isSelected());
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPeticion();
			}
		});

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modificar();

			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eliminar();

			}
		});

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
							.addComponent(btnEliminar)
							.addGap(34)
							.addComponent(chbxResultadosCriticos))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(15)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEliminar)
								.addComponent(btnModificar)
								.addComponent(btnAgregar)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(chbxResultadosCriticos)))
					.addContainerGap(23, Short.MAX_VALUE))
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
