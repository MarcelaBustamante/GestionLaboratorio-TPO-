package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import collections.FileUtils;
import controller.PacienteController;
import controller.PeticionesController;
import controller.PracticaController;
import controller.SucursalController;
import dto.PeticionDTO;
import model.EstadoPeticion;


public class AltaPeticion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String[] listSucursales;
	private String[] listPracticas;
	private PeticionesController controladorPeticion;
	private SucursalController controladorSucursal;
	private PracticaController controladorPractica;
	private PacienteController controladorPaciente;
	private JTextField txtID;
	private JComboBox<String> txtIDSucursal;
	private JTextField txtDNIPaciente;
	private JTextField txtObraSocial;
	private JFormattedTextField txtFCarga;
	private EstadoPeticion estado = EstadoPeticion.Activa;
	private PeticionDTO peticion = new PeticionDTO(); 
	private ModalResult modalResult;
	private JComboBox<String> textPracticaID;
	private JFormattedTextField textFechaEntrega;
	
	
	
	public AltaPeticion(JFrame frame) {
		super(frame, "Peticion", true);
		setLocationRelativeTo(frame);
		controladorPeticion = new PeticionesController();
		controladorSucursal = new SucursalController();
		controladorPractica = new PracticaController();
		controladorPaciente = new PacienteController();
		listSucursales = controladorSucursal.listarSucursales().stream()
				.map(suc->String.valueOf(suc.getIdSucursal()))
				.collect(Collectors.toList()).toArray(new String[0]);
		listPracticas = controladorPractica.listaPracticas().stream()
				.map(pra -> String.valueOf(pra.getCodigoPractica()))
				.collect(Collectors.toList()).toArray(new String[0]);
		inicializarControles();
		asignarFormato();
		
	}

	private void asignarDatosEntidad() {
		peticion.setIdPeticion(Integer.parseInt(txtID.getText()));
		peticion.setIdSucursal(Integer.parseInt(txtIDSucursal.getItemAt(txtIDSucursal.getSelectedIndex())));
		peticion.setObraSocial(txtObraSocial.getText());
		peticion.setDniPaciente(Integer.parseInt(txtDNIPaciente.getText()));
		peticion.setFechaCarga(txtFCarga.getText());
		peticion.setPracticaAsociada(Integer.parseInt(textPracticaID.getItemAt(textPracticaID.getSelectedIndex())));
		peticion.setFechaEntrega(textFechaEntrega.getText());
		peticion.setEstado(estado);
		if(validarForm(peticion))controladorPeticion.agregarPeticion(peticion);
	}
	
	private void asignarDatosForm(){
		txtID.setText(String.valueOf(peticion.getIdPeticion()));
		txtIDSucursal.setModel(new DefaultComboBoxModel<String>(listSucursales));
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
	/**
	 * Valida si los datos de fecha y paciente son los deseados
	 * @param p
	 * @return boolean
	 */
	public boolean validarForm(PeticionDTO p) {
		if(FileUtils.validarFecha(p.getFechaCarga()) && FileUtils.validarFecha(p.getFechaEntrega())) {
			if(controladorPaciente.existePaciente(p.getDniPaciente())){
				return true;	
			}else {
				JOptionPane.showMessageDialog(null,"El paciente no existe");
				return false;
			}
		}else {
			JOptionPane.showMessageDialog(null,"Formato de fecha invalido");
			return false;
		}
	}
	
	private void inicializarControles() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PeticionABM.class.getResource("/res/hospital4.png")));
		setBounds(100, 100, 660, 306);
		setTitle("Alta de Peticiones");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblID = new JLabel("ID");
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setText(String.valueOf(controladorPeticion.listaPeticiones().size() + 1));
		txtID.setEditable(false);
		
		JLabel lblsucursalID = new JLabel("Seleccionar Sucursal");
		txtIDSucursal = new JComboBox<String>();
		txtIDSucursal.setModel(new DefaultComboBoxModel<String>(listSucursales));
		
		JLabel lblDNI = new JLabel("DNI");
		txtDNIPaciente = new JTextField();
		txtDNIPaciente.setColumns(10);
		
		JLabel lblObraSocial = new JLabel("Obra Social");
		txtObraSocial = new JTextField();
		txtObraSocial.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("Fecha de inicio");
		txtFCarga = new JFormattedTextField();
		
		JLabel lblPractica = new JLabel("Seleccionar Practica");
		textPracticaID =  new JComboBox<String>();
		textPracticaID.setModel(new DefaultComboBoxModel<String>(listPracticas));
		
		JLabel lblFechaEntrega = new JLabel("Fecha de entrega");
		
		textFechaEntrega = new JFormattedTextField();
		textFechaEntrega.setColumns(10);
		
		JLabel lblFormatoFecha = new JLabel("DD/MM/AAAA");
		
		JLabel label = new JLabel("DD/MM/AAAA");
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblObraSocial)
						.addComponent(lblFechaInicio)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblsucursalID)
							.addComponent(lblDNI, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblID))
						.addComponent(lblPractica)
						.addComponent(lblFechaEntrega))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(textPracticaID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtObraSocial)
						.addComponent(txtIDSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDNIPaciente)
						.addComponent(txtID, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textFechaEntrega, 0, 0, Short.MAX_VALUE)
								.addComponent(txtFCarga, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFormatoFecha, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))))
					.addGap(248))
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
						.addComponent(txtFCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFormatoFecha))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPractica)
						.addComponent(textPracticaID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaEntrega)
						.addComponent(label)
						.addComponent(textFechaEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
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
	
}
