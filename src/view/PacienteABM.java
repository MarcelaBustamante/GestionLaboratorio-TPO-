package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import view.ModalResult;
import view.tablemodel.PacienteTableModel;

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

import controller.PacienteController;
import collections.PacienteCollection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Color;

public class PacienteABM extends JFrame {
	private PacienteController pacientes;
	private JFrame frame;
	private JPanel pacientePanel;
	private JPanel panel_1;
	private JTable tablePacientes;
	private PacienteTableModel tableModelPaciente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacienteABM window = new PacienteABM();
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
	public PacienteABM() {
		pacientes = new PacienteController();
		tableModelPaciente = new PacienteTableModel(pacientes.listaPacientes());
		inicializar();
	}

	private void agregarPaciente() {
		try {
			//abre un alta de Paciente
			AltaPaciente dialog = new AltaPaciente(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			JOptionPane.showMessageDialog(null, "finalizado");
			if (dialog.getModalResult() == ModalResult.OK) {
				tableModelPaciente.agregar(dialog.getPaciente());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	private void modificar() {
		try {
			AltaPaciente dialog = new AltaPaciente(frame);
			dialog.setPaciente(pacientes.obtenerPaciente((tablePacientes.getSelectedRow())));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			JOptionPane.showMessageDialog(null, "El paciente ha sido modificado");
			if (dialog.getModalResult() == ModalResult.OK)
				tableModelPaciente.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void eliminar() {
		if(pacientes.existePetiFinalizada(tablePacientes.getSelectedRow())) {
			JOptionPane.showMessageDialog(frame, "No se puede eliminar el paciente, existen peticiones finalizadas");
		}
		else

			JOptionPane.showMessageDialog(frame, "El paciente ha sido eliminado");
		tableModelPaciente.refresh();
	}
	private void inicializar() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}				
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(PeticionABM.class.getResource("/res/hospital4.png")));
		setTitle("ABM Pacientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1101, 570);
		pacientePanel = new JPanel();
		pacientePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pacientePanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		panel_1 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pacientePanel = new GroupLayout(pacientePanel);
		gl_pacientePanel.setHorizontalGroup(
			gl_pacientePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pacientePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
		);
		gl_pacientePanel.setVerticalGroup(
			gl_pacientePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pacientePanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
		);
		tablePacientes = new JTable(tableModelPaciente);
		tablePacientes.setAutoCreateRowSorter(true);
		tablePacientes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tablePacientes);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPaciente();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblPacientes = new JLabel("ABM Pacientes");
		panel.add(lblPacientes);
		lblPacientes.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblPacientes.setBackground(Color.DARK_GRAY);
		pacientePanel.setLayout(gl_pacientePanel);
		
	}
	
}
