package view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

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
import controller.PeticionesController;
import controller.PracticaController;
import controller.SucursalController;
import dto.PacienteDTO;
import dto.PeticionDTO;
import javafx.scene.control.ComboBox;
import model.EstadoPeticion;
import model.Paciente;
import view.ModalResult;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;


public class AltaPaciente extends JDialog {
//"ID", "Dni", "Nombre", "Domicilio", "Mail", "Sexo", "Edad"
	private final JPanel contentPanel = new JPanel();
	private PacienteController controladorPaciente;
	private PacienteDTO paciente = new PacienteDTO(); 
	private JTextField txtID;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtDomicilio;
	private JTextField txtMail;
	private JTextField txtEdad;
	//private JTextField txtSexo;
	private JComboBox<String> sexobox;
	private ModalResult modalResult;
	private JTextField textField;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	private void inicializarControles() {
		setBounds(100, 100, 660, 306);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("ID");
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setText(String.valueOf(controladorPaciente.obtenerUltimoId() + 1));
		txtID.setEditable(false);
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char validar = arg0.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					arg0.consume();
					JOptionPane.showMessageDialog(rootPane, "ingrese unicamente numeros");
				}
			}
		});
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Dni");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char validar = arg0.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					arg0.consume();
					JOptionPane.showMessageDialog(rootPane, "ingrese unicamente numeros");
				}
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char validar = arg0.getKeyChar();
				if(Character.isDigit(validar)) {
					getToolkit().beep();
					arg0.consume();
					JOptionPane.showMessageDialog(rootPane, "ingrese unicamente letras");
				}
			}
		});
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mail");
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		
		/*JLabel lblNewLabel_3 = new JLabel("Sexo");
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		*/
		JLabel lblNewLabel_4 = new JLabel("Edad");
		
		txtEdad= new JTextField();
		txtEdad.setColumns(10);
		txtEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char validar = arg0.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					arg0.consume();
					JOptionPane.showMessageDialog(rootPane, "ingrese unicamente numeros");
				}
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		sexobox= new JComboBox();
		sexobox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		
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
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
							.addComponent(lblDomicilio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(sexobox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(txtDomicilio, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(txtMail, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(txtID, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(txtDni, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(txtEdad, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
					.addGap(299))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDomicilio)
						.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(sexobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					asignarDatosEntidad();
					modalResult = ModalResult.OK;
					dispose();
				}
			});
			{
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					modalResult = ModalResult.CANCELL;
					dispose();
				}
			});
			{
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	public AltaPaciente(JFrame frame) {
		super(frame, "Paciente", true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaPaciente.class.getResource("/res/hospital4.png")));
		setLocationRelativeTo(frame);
		controladorPaciente = new PacienteController();
		inicializarControles();
	}

	

	private void asignarDatosEntidad() {
        paciente.setIdPaciente(Integer.parseInt(txtID.getText()));
        paciente.setDni(Integer.parseInt(txtDni.getText()));
        paciente.setNombre(txtNombre.getText());
        paciente.setDomicilio(txtDomicilio.getText());
        paciente.setMail(txtMail.getText());
        paciente.setSexo(sexobox.getItemAt(sexobox.getSelectedIndex()));
        paciente.setEdad(Integer.parseInt(txtEdad.getText()));
		controladorPaciente.agregarPaciente(paciente);
	}
	private void asignarDatosForm(){
		txtID.setText(String.valueOf(paciente.getIdPaciente()));
		txtDni.setText(String.valueOf(paciente.getDni()));
		txtNombre.setText(paciente.getNombre());
		txtDomicilio.setText(paciente.getDomicilio());
		txtMail.setText(paciente.getMail());
		sexobox.setActionCommand(paciente.getSexo());
		txtEdad.setText(String.valueOf(paciente.getEdad()));
	}
	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
		asignarDatosForm();
	}
	public PacienteDTO getPaciente() {
		return paciente;
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
