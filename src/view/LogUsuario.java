package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class LogUsuario {

	private JFrame frmIngreso;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogUsuario window = new LogUsuario();
					window.frmIngreso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngreso = new JFrame();
		frmIngreso.setIconImage(Toolkit.getDefaultToolkit().getImage(LogUsuario.class.getResource("/res/hospital4.png")));
		frmIngreso.getContentPane().setBackground(new Color(128, 128, 128));
		frmIngreso.setTitle("Ingreso Usuario");
		frmIngreso.setBounds(100, 100, 487, 329);
		frmIngreso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngreso.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setForeground(new Color(173, 216, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(190, 28, 116, 16);
		frmIngreso.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(22, 83, 56, 16);
		frmIngreso.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setBounds(22, 144, 79, 16);
		frmIngreso.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(125, 80, 116, 22);
		frmIngreso.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(190, 244, 97, 25);
		frmIngreso.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 141, 116, 22);
		frmIngreso.getContentPane().add(passwordField);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuView p = new MenuView();
				frmIngreso.setVisible(false);
				p.main(null);
			}
		});
	}
}
