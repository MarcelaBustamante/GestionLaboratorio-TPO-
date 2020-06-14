package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SucursalController;
import controller.UsuarioController;
import dto.SucursalDTO;
import dto.UsuarioDTO;
import model.EstadoSucursal;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.EstadoSucursal;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
@SuppressWarnings("unused")
public class AltaSucursal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtidSucursal;
	private JTextField txtDireccion;
	private JTextField textResponsableTecnico;
	private SucursalController controladorDeSucursal;
	private ModalResult modalResult;
	JButton guardarButton;
	JButton cancelButton;
	@SuppressWarnings("rawtypes")
	JComboBox comboEstado;
	
	/**
	 * Launch the application.
	 */

//Aca manejo todos los eventos
	public void inicializarEventos() {
		
		//Manejo para que solo ingresen numeros como id de sucursal
		txtidSucursal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char validar = arg0.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(rootPane, "ingrese unicamente números");
				}
			}
		});
		
	
		guardarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignarDatosEntidad();
				modalResult = ModalResult.OK;
				dispose();//Cierro la pantalla
			}
		});
		
		
	}
	
	
	
/*----------------------------------------------------------------------------------------------*/
	/**
	 * Create the dialog.
	 */
	//Encapsulo todo lo que pasa en el form
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void inicializarPantalla() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {e.printStackTrace();}
		
		
		setTitle("Nueva sucursal");
		setBounds(100, 100, 504, 247);
		getContentPane().setLayout(new BorderLayout());
		
		
		//Titulo
				JLabel lblNuevaSucursal = new JLabel("Nueva sucursal");
				lblNuevaSucursal.setForeground(Color.DARK_GRAY);
				lblNuevaSucursal.setFont(new Font("Tahoma", Font.PLAIN, 18));

		//Id sucursal
		JLabel lblSucurusal = new JLabel("Identificador de surcursal");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			txtidSucursal = new JTextField();
			txtidSucursal.setColumns(10);
		}
		
		//Dir de sucursal
		JLabel lblDireccion = new JLabel("Direcci\u00F3n de sucursal");
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		
		//Responsable tecnico
		JLabel lblResponsableTcnico = new JLabel("Responsable t\u00E9cnico");
		textResponsableTecnico = new JTextField();
		textResponsableTecnico.setColumns(10);
		
		//Combo de sucursales
		JLabel lblEstadoSucursal = new JLabel("Estado sucursal");
		
		comboEstado = new JComboBox();
		comboEstado.setModel(new DefaultComboBoxModel(EstadoSucursal.values()));
		//comboEstado.setModel(new DefaultComboBoxModel(new String[] {"Activa", "Inactiva"}));
		
		
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtidSucursal, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDireccion)
								.addComponent(lblSucurusal))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEstadoSucursal)
								.addComponent(textResponsableTecnico, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblResponsableTcnico)
								.addComponent(comboEstado, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNuevaSucursal)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNuevaSucursal)
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSucurusal)
						.addComponent(lblEstadoSucursal))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtidSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDireccion)
						.addComponent(lblResponsableTcnico))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textResponsableTecnico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				guardarButton = new JButton("Guardar");
				guardarButton.setActionCommand("guardar");
				buttonPane.add(guardarButton);
				getRootPane().setDefaultButton(guardarButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
		
	public AltaSucursal(JFrame frame) {
		super(frame, "Usuario", true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaUsuario.class.getResource("/res/hospital4.png")));
		setLocationRelativeTo(frame);
		controladorDeSucursal = new SucursalController();
		inicializarPantalla();
		inicializarEventos();
	}
	
	//Guardo los datos que se cargaron en el FORM
	private void asignarDatosEntidad() {
		int i = Integer.parseInt(txtidSucursal.getText());//transformo el string del campo de texto a un entero
		int idSucursal = i;
		String direccion = txtDireccion.getText();
		String responsableTecnico = textResponsableTecnico.getText();
		EstadoSucursal estado =  (EstadoSucursal)comboEstado.getSelectedItem();//casteo el item seleccionado para que sea un tipo enum
		controladorDeSucursal.addSucursal(direccion, responsableTecnico, idSucursal, estado);
		
	}
	public SucursalDTO getSucursalDTO() {
		return controladorDeSucursal.getSucursalDTO();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}


}
