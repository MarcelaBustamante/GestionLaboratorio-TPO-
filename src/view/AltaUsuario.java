package view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.MaskFormatter;

import org.omg.CORBA.PRIVATE_MEMBER;

import controller.PacienteController;
import controller.UsuarioController;
import dto.PacienteDTO;
import dto.UsuarioDTO;
import javafx.scene.control.ComboBox;
import model.EstadoPeticion;
import view.ModalResult;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;


public class AltaUsuario extends JDialog {
//"ID", "Dni", "Nombre", "Domicilio", "Mail", "Sexo", "Edad"
	private final JPanel contentPanel = new JPanel();
	private UsuarioController controladorController;
	private JTextField txtNombreUsuario;
	private JFormattedTextField txtFechaNacimiento;
	private JTextField txtContraseña;
	private JTextField txtDomicilio;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtMail;
	private JComboBox<String> rolbox;
	private ModalResult modalResult;
	private JTextField textField;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	
	private void inicializarControles() {
		setBounds(100, 100, 764, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario");
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Nacimiento");
		
		txtFechaNacimiento = new JFormattedTextField();
		txtFechaNacimiento.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Dni");
		
		txtDni= new JTextField();
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Mail");
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		rolbox= new JComboBox();
		rolbox.setModel(new DefaultComboBoxModel(new String[] {"Recepcion", "Laboratorista", "Administrador"}));
		
		JLabel lblNewLabel_6 = new JLabel("Rol");
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel)
							.addComponent(lblNewLabel_2)
							.addComponent(lblNewLabel_4)
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
							.addComponent(lblDomicilio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1))
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rolbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDni)
						.addComponent(txtNombre)
						.addComponent(txtDomicilio)
						.addComponent(txtContraseña)
						.addComponent(txtFechaNacimiento)
						.addComponent(txtNombreUsuario, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
						.addComponent(txtMail))
					.addContainerGap(293, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtNombreUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtFechaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDomicilio)
						.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(rolbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						asignarDatosEntidad();
						modalResult = ModalResult.OK;
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						modalResult = ModalResult.CANCELL;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	private void asignarFormato() {
		try {
			try {
				txtFechaNacimiento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}
		catch (Exception e) {e.printStackTrace();}		
	}
	public AltaUsuario(JFrame frame) {
		super(frame, "Usuario", true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaUsuario.class.getResource("/res/hospital4.png")));
		setLocationRelativeTo(frame);
		controladorController = new UsuarioController();
		inicializarControles();
		asignarFormato();
	}

	

	private void asignarDatosEntidad() {
		
		String nombreUsuario = txtNombreUsuario.getText();
		String fechaNacimiento = txtFechaNacimiento.getText();
		String contraseña = txtContraseña.getText();
		String domicilio = txtDomicilio.getText();
		String nombre= txtNombre.getText();
		int dni= Integer.parseInt(txtDni.getText());
		String mail = txtMail.getText();
		String rol = rolbox.getItemAt(rolbox.getSelectedIndex());
		controladorController.altaUsuario(nombreUsuario, fechaNacimiento, contraseña, domicilio,nombre, dni, mail, rol);
	}
	
	public UsuarioDTO getUsuarioDTO() {
		return controladorController.getUsuarioDTO();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
