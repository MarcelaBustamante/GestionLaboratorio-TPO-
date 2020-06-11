package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.PracticaController;
import dto.PracticaDTO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PracticaABM extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCodigo;
	private JTextField textFieldNombre;
	private JTextField textFieldGrupo;
	private JTextField textFieldValCriticos;
	private JTextField textFieldValReservados;
	private JTextField textFieldCantHoras;
	private ModalResult modalResult;
	private PracticaDTO practica = new PracticaDTO();
	private PracticaController practicaController = new PracticaController();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	private void inicializarControles() {
		setTitle("Practica");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Grupo");
		
		textFieldGrupo = new JTextField();
		textFieldGrupo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Val. Criticos");
		
		textFieldValCriticos = new JTextField();
		textFieldValCriticos.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Val. Reservados");
		
		textFieldValReservados = new JTextField();
		textFieldValReservados.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Cant. Horas");
		
		textFieldCantHoras = new JTextField();
		textFieldCantHoras.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldCodigo, Alignment.TRAILING)
								.addGroup(Alignment.TRAILING, gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textFieldNombre, Alignment.TRAILING)
									.addComponent(textFieldGrupo, Alignment.TRAILING)
									.addComponent(textFieldValCriticos, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldValReservados))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(18)
							.addComponent(textFieldCantHoras)))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textFieldGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textFieldValCriticos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textFieldValReservados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textFieldCantHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
					public void actionPerformed(ActionEvent e) {
						modalResult = ModalResult.CANCELL;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public PracticaABM(JFrame frame) {
		super(frame, "Persona", true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PracticaABM.class.getResource("/res/hospital4.png")));
		setLocationRelativeTo(frame);
		practicaController = new PracticaController();
		inicializarControles();
	}
	
	public ModalResult getModalResult() {
		return modalResult;
	}
	
	public PracticaDTO getPractica() {
		return practica;
	}
	
	private void asignarDatosEntidad() {
		practica.setCodigoPractica(textFieldCodigo.getText());
		practica.setNombrePractica(textFieldNombre.getText());
		practica.setGrupo(textFieldGrupo.getText());
		practica.setValoresCriticos(textFieldValCriticos.getText());
		practica.setValoresReservados(textFieldValReservados.getText());
		practica.setDate(textFieldCantHoras.getText());
		practicaController.agregarPractica(practica);
		
	}
	
	private void asignarDatosForm(){
		textFieldCodigo.setText(practica.getCodigoPractica());
		textFieldNombre.setText(practica.getNombrePractica());
		textFieldGrupo.setText(practica.getGrupo());
		textFieldValCriticos.setText(practica.getValoresCriticos());
		textFieldCantHoras.setText(practica.getValoresReservados());
		textFieldValReservados.setText(practica.getDate());
	}
	
	public void setPractica(PracticaDTO practica) {
		this.practica = practica;
		asignarDatosForm();
	}
}
