package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class SucursalABM {

	private JFrame frmAbmDeSucursales;
	private JTable table;
	//Declaro los botones aca ya que cambie la estructura original del archivo como hizo el profe
	private JButton btnAgregar, btnModificar, btnEliminar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SucursalABM window = new SucursalABM();
					window.frmAbmDeSucursales.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SucursalABM() {
		inicializarPantalla();
		inicializarEventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//Aca inicializo los eventos
	private void inicializarEventos() {
	}
	//Aca inicializo la pantalla
	private void inicializarPantalla() {
		
		//Elimino el look and feel de java  y pongo el nativo del sistema
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {e.printStackTrace();}
		
		frmAbmDeSucursales = new JFrame();
		frmAbmDeSucursales.setTitle("ABM de Sucursales");
		frmAbmDeSucursales.setBounds(100, 100, 526, 398);
		frmAbmDeSucursales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centro la pantalla
		frmAbmDeSucursales.setLocationRelativeTo(null);
		table = new JTable();
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		//Boton modificar
		btnModificar = new JButton("Modificar");
		
		//Boton eliminar
		btnEliminar = new JButton("Eliminar");
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de sucursales");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frmAbmDeSucursales.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
						.addComponent(table, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnAgregar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnModificar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEliminar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnModificar)
						.addComponent(btnEliminar))
					.addContainerGap())
		);
		frmAbmDeSucursales.getContentPane().setLayout(groupLayout);
	}
}
