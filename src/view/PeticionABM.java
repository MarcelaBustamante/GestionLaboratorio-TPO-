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
import java.awt.Color;

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
	
	private void mostrarResultados() {
		ResultadoPeticionABM dialog = new ResultadoPeticionABM(frame,peticiones.obtenerPeticion(tablePeticiones.getSelectedRow()),peticiones);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
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
		gl_peticionPanel.setHorizontalGroup(
			gl_peticionPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
				.addGroup(gl_peticionPanel.createSequentialGroup()
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_peticionPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_peticionPanel.setVerticalGroup(
			gl_peticionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_peticionPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		);

		tablePeticiones = new JTable(tableModelPeticion);
		tablePeticiones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
		          	mostrarResultados();
				}
		});
		tablePeticiones.setAutoCreateRowSorter(true);
		tablePeticiones.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tablePeticiones);

		chbxResultadosCriticos = new JCheckBox("Ver peticiones con resultados criticos");
		chbxResultadosCriticos.setBounds(243, 44, 201, 23);
		chbxResultadosCriticos.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				visualizarCriticos(((JCheckBox) e.getItem()).isSelected());
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 44, 71, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPeticion();
			}
		});

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(87, 44, 75, 23);
		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modificar();

			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(168, 44, 69, 23);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eliminar();

			}
		});

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 28, 605, 2);
		
		JLabel lblNota = new JLabel("Para ver los resultados dobleclick en la peticion");
		lblNota.setForeground(Color.RED);
		lblNota.setFont(new Font("Verdana", Font.ITALIC, 11));
		lblNota.setBounds(292, 3, 288, 14);
		panel_1.setLayout(null);
		panel_1.add(btnAgregar);
		panel_1.add(btnModificar);
		panel_1.add(btnEliminar);
		panel_1.add(chbxResultadosCriticos);
		panel_1.add(separator);
		panel_1.add(lblNota);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblPeticiones = new JLabel("ABM Peticiones");
		panel.add(lblPeticiones);
		lblPeticiones.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblPeticiones.setBackground(SystemColor.desktop);
		peticionPanel.setLayout(gl_peticionPanel);

	}
}
