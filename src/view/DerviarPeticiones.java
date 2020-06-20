package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SucursalController;
import dto.SucursalDTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class DerviarPeticiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel Izq;
	private JPanel buttonPane;
	private JComboBox dropdownsucDestino;
	private JLabel lblSucOrigen;
	private JTextField txtsucOrigen;
	int idSucursal;
	private SucursalController controladorDeSucursal;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DerviarPeticiones dialog = new DerviarPeticiones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inicializarEventos(){
		
	}
	
	public void inicializarPantalla() {
		setBounds(100, 100, 443, 231);
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setAlignment(FlowLayout.LEFT);
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			JLabel lblReasignacionPeticiones = new JLabel("Reasignación de peticiones");
			lblReasignacionPeticiones.setHorizontalAlignment(SwingConstants.LEFT);
			lblReasignacionPeticiones.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPanel.add(lblReasignacionPeticiones);
		}
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("Derivar peticiones");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			Izq = new JPanel();
			getContentPane().add(Izq, BorderLayout.CENTER);
		}
		{
			dropdownsucDestino = new JComboBox();
		}
		{
			lblSucOrigen = new JLabel("Sucursal Origen");
		}
		
		txtsucOrigen = new JTextField();
		txtsucOrigen.setColumns(10);
		
		JLabel lblSucDestino = new JLabel("Sucursal Destino");
		
		JLabel lblNewLabel = new JLabel("<html><pre>Se transferiran las peticiones de la sucursal de <br> origen a la sucursal de origen seleccionada</pre></html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout gl_Izq = new GroupLayout(Izq);
		gl_Izq.setHorizontalGroup(
			gl_Izq.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Izq.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_Izq.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Izq.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_Izq.createSequentialGroup()
							.addGroup(gl_Izq.createParallelGroup(Alignment.LEADING)
								.addComponent(txtsucOrigen, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSucOrigen))
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addGroup(gl_Izq.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSucDestino)
								.addComponent(dropdownsucDestino, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
							.addGap(55))))
		);
		gl_Izq.setVerticalGroup(
			gl_Izq.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Izq.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Izq.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSucOrigen)
						.addComponent(lblSucDestino))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_Izq.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtsucOrigen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dropdownsucDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
		);
		Izq.setLayout(gl_Izq);
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}
		public DerviarPeticiones(JFrame frame) {
	//public DerviarPeticiones(JFrame frame) {
		//super(frame, "Usuario", true);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(AltaUsuario.class.getResource("/res/hospital4.png")));
		//setLocationRelativeTo(frame);
		//controladorDeSucursal = new SucursalController();
		inicializarPantalla();
		inicializarEventos();
	}
		public DerviarPeticiones()
		{
			inicializarPantalla();
			inicializarEventos();
		}
		
		public void setSucursalOringenDestino(SucursalDTO sucursal,List<SucursalDTO> listaSucursales) {
			txtsucOrigen.setText(String.valueOf(sucursal.getIdSucursal()));
			//String[] array = listaSucursales.toArray(new String[listaSucursales.size()]);
			//dropdownsucDestino.getModel().setSelectedItem(array);
	
		}
}
