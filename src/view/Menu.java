package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu del sistema");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuSucursales = new JMenuItem("Sucursales");
		mnNewMenu.add(menuSucursales);
		
		JMenuItem menuPeticiones = new JMenuItem("Peticiones");
		menuPeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peticion p = new Peticion();
				p.main(null);
			}
		});
		mnNewMenu.add(menuPeticiones);
		
		JMenuItem menuUsuarios = new JMenuItem("Usuarios");
		mnNewMenu.add(menuUsuarios);
		
		JMenuItem menuPacientes = new JMenuItem("Pacientes");
		mnNewMenu.add(menuPacientes);
		
		JMenuItem menuPracticas = new JMenuItem("Practicas");
		mnNewMenu.add(menuPracticas);
		
		JMenuItem menuCerrar = new JMenuItem("Cerrar");
		menuCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(menuCerrar);
	}

}
