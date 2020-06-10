package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import collections.PracticaCollection;
import view.tablemodel.PracticaTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PracticaView {

	private JFrame frame;
	private JTable table;
	private PracticaCollection coleccionPracticas;
	private PracticaTableModel practicaTableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticaView window = new PracticaView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PracticaView() {
		coleccionPracticas = new PracticaCollection();
		practicaTableModel = new PracticaTableModel(coleccionPracticas);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void agregarPractica() {
		try {
			PracticaABM dialog = new PracticaABM(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			JOptionPane.showMessageDialog(null, "termineeee");
			if (dialog.getModalResult() == ModalResult.OK)
				practicaTableModel.agregar(dialog.getPractica());
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	private void modificarPractica() {
		try {
			PracticaABM dialog = new PracticaABM(frame);
			dialog.setPractica(coleccionPracticas.getPractica(table.getSelectedRow()));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				practicaTableModel.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPractica();
			}
		});
		panel.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPractica();
			}
		});
		panel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ABM Practicas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(practicaTableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
		          	modificarPractica();
			}
		});
		table.setModel(practicaTableModel);
		table.getColumnModel().getColumn(4).setPreferredWidth(89);
		table.getColumnModel().getColumn(5).setPreferredWidth(117);
		scrollPane.setViewportView(table);
	}

}
