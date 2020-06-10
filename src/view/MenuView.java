package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MenuView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView window = new MenuView();
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
	public MenuView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}			
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/res/hospital4.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu del sistema");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuSucursales = new JMenuItem("Sucursales");
		mnNewMenu.add(menuSucursales);
		
		JMenuItem menuPeticiones = new JMenuItem("Peticiones");
		menuPeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeticionView p = new PeticionView();
				p.main(null);
			}
		});
		mnNewMenu.add(menuPeticiones);
		
		JMenuItem menuUsuarios = new JMenuItem("Usuarios");
		menuUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioView p = new UsuarioView();
				p.main(null);
			}
		});
		mnNewMenu.add(menuUsuarios);
		
		JMenuItem menuPacientes = new JMenuItem("Pacientes");
		menuPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteView p = new PacienteView();
				p.main(null);
			}
		});
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
