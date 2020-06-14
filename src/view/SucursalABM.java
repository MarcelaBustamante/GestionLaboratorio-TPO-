package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;

import collections.SucursalCollection;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import view.tablemodel.SucursalTableModel;
import view.tablemodel.UsuarioTableModel;
public class SucursalABM {

	private JFrame frmAbmDeSucursales;
	//Declaro los botones aca ya que cambie la estructura original del archivo como hizo el profe
	private SucursalCollection sucursales;
	private JButton btnAgregar, btnModificar, btnEliminar;
	private JScrollPane scrollPane;
	private JTable tableSucursales;
	private SucursalTableModel tableModelSucursal;
	
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
		
		sucursales = new SucursalCollection();
		tableModelSucursal = new SucursalTableModel(sucursales);
		
		inicializarPantalla();
		inicializarEventos();
	}

	private void agregarSucursal() {
		try {
			//abre un alta de peticion
			AltaSucursal dialog = new AltaSucursal(frmAbmDeSucursales);
			//AltaSucursal dialog = new AltaSucursal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			JOptionPane.showMessageDialog(null, "Finalizado");
			if (dialog.getModalResult() == ModalResult.OK)
				tableModelSucursal.agregar(dialog.getSucursalDTO());
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	//Aca inicializo los eventos
	private void inicializarEventos() {
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarSucursal();
			}
		});
		
		
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
		frmAbmDeSucursales.setLocationRelativeTo(null);		//centro la pantalla
		
		JPanel panelBotones = new JPanel();
		
		JPanel panelTitulo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.setBackground(new Color(192, 192, 192));
		
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de sucursales");
		panelTitulo.add(lblNewLabel);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		//Boton Agregar
		btnAgregar = new JButton("Agregar");
		panelBotones.add(btnAgregar);

		//Boton modificar
		btnModificar = new JButton("Modificar");
		panelBotones.add(btnModificar);
		
		//Boton eliminar
		btnEliminar = new JButton("Eliminar");
		panelBotones.add(btnEliminar);
		frmAbmDeSucursales.getContentPane().setLayout(new BorderLayout(0, 0));
		frmAbmDeSucursales.getContentPane().add(panelTitulo, BorderLayout.NORTH);
		frmAbmDeSucursales.getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		frmAbmDeSucursales.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		tableSucursales = new JTable(tableModelSucursal);//indico las columnas que debe tener
		scrollPane.setViewportView(tableSucursales);
	}
}
