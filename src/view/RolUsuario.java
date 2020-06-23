package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.UsuarioController;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RolUsuario extends JDialog {

	private UsuarioController controladorUsuario = new UsuarioController();
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RolUsuario dialog = new RolUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RolUsuario() {
		setTitle("Rol Usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RolUsuario.class.getResource("/res/hospital4.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel("Bienvenido");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Rol");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char caracter=arg0.getKeyChar();
				if(Character.isUpperCase(caracter)) {
					arg0.setKeyChar(Character.toLowerCase(caracter));
				}
			}
		});
		textField_1.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
									.addComponent(lblNewLabel)))
							.addGap(159))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(45)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setActionCommand("Aceptar");
				okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						if(textField_1.getText().equals("recepcion")||textField_1.getText().equals("laboratorista")||textField_1.getText().equals("administrador")) {
							if(controladorUsuario.checkRol(textField.getText(),textField_1.getText())) {
								JOptionPane.showMessageDialog(rootPane, "Bienvenido");
								if(textField_1.getText().equals("administrador")) {
									MenuView s = new MenuView();
									s.main(null);
								}
								if(textField_1.getText().equals("recepcion")) {
									Menuview1 s= new Menuview1();
									s.main(null);
								}
								if(textField_1.getText().equals("laboratorista")) {
									Menuview2 s= new Menuview2();
									s.main(null);
								}
						}
							else {
								JOptionPane.showMessageDialog(rootPane, "El usuario ingresado o el rol no son correctos, vuelva a intentarlo");
							}			
						}
						else {
							JOptionPane.showMessageDialog(rootPane, "El rol ingresado no existe, vuelva a intentarlo");
						}
				}	
			});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
