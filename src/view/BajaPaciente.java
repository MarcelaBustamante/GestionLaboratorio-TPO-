package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BajaPaciente {

	private JFrame frmBajaPaciente;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaPaciente window = new BajaPaciente();
					window.frmBajaPaciente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BajaPaciente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBajaPaciente = new JFrame();
		frmBajaPaciente.setTitle("Baja Paciente");
		frmBajaPaciente.setBounds(100, 100, 449, 204);
		frmBajaPaciente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBajaPaciente.getContentPane().setLayout(null);
		
		JLabel txtDni = new JLabel("Ingrese el Dni");
		txtDni.setBounds(12, 56, 122, 16);
		frmBajaPaciente.getContentPane().add(txtDni);
		
		textField = new JTextField();
		textField.setBounds(133, 53, 260, 22);
		frmBajaPaciente.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
            }
		});
		btnNewButton.setBounds(164, 119, 97, 25);
		frmBajaPaciente.getContentPane().add(btnNewButton);
	}
}
