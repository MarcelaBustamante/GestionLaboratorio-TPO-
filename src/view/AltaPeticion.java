package view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Toolkit;
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

import controller.PeticionesController;
import dto.PeticionDTO;
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


public class AltaPeticion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private PeticionesController controladorPeticion;
	private JTextField txtID;
	private JTextField txtIDSucursal;
	private JTextField txtDNIPaciente;
	private JTextField txtObraSocial;
	private JFormattedTextField txtFCarga;
	private EstadoPeticion estado = EstadoPeticion.Activa;
	private PeticionDTO peticion = new PeticionDTO(); 
	private ModalResult modalResult;
	private JTextField textPracticaID;
	private JFormattedTextField textFechaEntrega;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	
	private void inicializarControles() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PeticionView.class.getResource("/res/hospital4.png")));
		setBounds(100, 100, 660, 306);
		setTitle("Alta de Peticiones");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblID = new JLabel("ID");
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setText(String.valueOf(controladorPeticion.listaPeticiones().size()));
		
		JLabel lblsucursalID = new JLabel("Sucursal ID");
		txtIDSucursal = new JTextField();
		txtIDSucursal.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI");
		txtDNIPaciente = new JTextField();
		txtDNIPaciente.setColumns(10);
		
		JLabel lblObraSocial = new JLabel("Obra Social");
		txtObraSocial = new JTextField();
		txtObraSocial.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("Fecha de inicio");
		txtFCarga = new JFormattedTextField();
		
		JLabel lblPractica = new JLabel("Practica ID");
		textPracticaID = new JTextField();
		textPracticaID.setColumns(10);
		
		
		JLabel lblFechaEntrega = new JLabel("Fecha de entrega");
		
		textFechaEntrega = new JFormattedTextField();
		textFechaEntrega.setColumns(10);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblFechaEntrega)
							.addGap(18)
							.addComponent(textFechaEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblObraSocial)
								.addComponent(lblFechaInicio)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblsucursalID)
									.addComponent(lblDNI, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(4)
									.addComponent(lblID))
								.addComponent(lblPractica))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFCarga, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textPracticaID)
									.addComponent(txtObraSocial)
									.addComponent(txtIDSucursal)
									.addComponent(txtDNIPaciente)
									.addComponent(txtID, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))))
					.addContainerGap(275, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblID)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIDSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblsucursalID))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDNIPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDNI))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtObraSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblObraSocial))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaInicio)
						.addComponent(txtFCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPractica)
						.addComponent(textPracticaID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaEntrega)
						.addComponent(textFechaEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
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
				txtFCarga.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
				textFechaEntrega.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}
		catch (Exception e) {e.printStackTrace();}		
	}
	
	public AltaPeticion(JFrame frame) {
		super(frame, "Peticion", true);
		setLocationRelativeTo(frame);
		controladorPeticion = new PeticionesController();
		inicializarControles();
		asignarFormato();
		
	}

	private void asignarDatosEntidad() {
		peticion.setIdPeticion(Integer.parseInt(txtID.getText()));
		peticion.setIdSucursal(Integer.parseInt(txtIDSucursal.getText()));
		peticion.setObraSocial(txtObraSocial.getText());
		peticion.setDniPaciente(Integer.parseInt(txtDNIPaciente.getText()));
		peticion.setFechaCarga(txtFCarga.getText());
		peticion.setPracticaAsociada(Integer.parseInt(textPracticaID.getText()));
		peticion.setFechaEntrega(textFechaEntrega.getText());
		peticion.setEstado(estado);
		controladorPeticion.agregarPeticion(peticion);
	}
	
	private void asignarDatosForm(){
		txtID.setText(String.valueOf(peticion.getIdPeticion()));
		txtIDSucursal.setText(String.valueOf(peticion.getIdSucursal()));
		txtObraSocial.setText(peticion.getObraSocial());
		txtDNIPaciente.setText(String.valueOf(peticion.getDniPaciente()));
		txtFCarga.setText(peticion.getFechaCarga());
		textFechaEntrega.setText(peticion.getFechaEntrega());
	}
	public void setPeticion(PeticionDTO peticion) {
		this.peticion = peticion;
		asignarDatosForm();
	}
	public PeticionDTO getPeticion() {
		return peticion;
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
