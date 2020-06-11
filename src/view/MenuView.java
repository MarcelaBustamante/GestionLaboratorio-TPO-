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
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

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
		frame.getContentPane().setBackground(new Color(255, 99, 71));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/res/hospital4.png")));
		frame.setBounds(100, 100, 498, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu del sistema");
		mnNewMenu.setForeground(new Color(255, 0, 0));
		mnNewMenu.setBackground(new Color(0, 0, 0));
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
		menuPracticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaView p = new PracticaView();
				p.main(null);
			}
		});
		mnNewMenu.add(menuPracticas);
		
		
		JMenuItem menuCerrar = new JMenuItem("Cerrar");
		menuCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(menuCerrar);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Sucursales");
		btnNewButton_2.setBounds(240, 2, 240, 43);
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Peticiones");
		btnNewButton.setBounds(240, 45, 240, 43);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeticionView p = new PeticionView();
				p.main(null);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Usuarios");
		btnNewButton_1.setBounds(240, 88, 240, 43);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioView p = new UsuarioView();
				p.main(null);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Pacientes");
		btnNewButton_3.setBounds(240, 131, 240, 43);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteView p = new PacienteView();
				p.main(null);
			}
		});
		
		JButton btnNewButton_4 = new JButton("Practicas");
		btnNewButton_4.setBounds(240, 174, 240, 43);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaView p = new PracticaView();
				p.main(null);
			}
		});
		
		JButton btnNewButton_5 = new JButton("Cerrar");
		btnNewButton_5.setBounds(0, 217, 149, 43);
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(240, 217, 240, 43);
		frame.getContentPane().add(label_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
