package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import collections.PeticionCollection;
import controller.PeticionesController;
import dto.PeticionDTO;
import model.EstadoPeticion;
import model.TipoValorCritico;
import view.tablemodel.PeticionTableModel;
import view.ModalResult;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

//import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Peticionview1 extends JFrame {
	private PeticionesController peticiones;

	private JFrame frame;
	private JPanel peticionPanel;
	private JPanel panel_1;
	private JTable tablePeticiones;
	private PeticionTableModel tableModelPeticion;
	private JCheckBox chbxResultadosCriticos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Peticionview1 window = new Peticionview1();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Peticionview1() {
		peticiones = new PeticionesController();
		tableModelPeticion = new PeticionTableModel(peticiones.listaPeticiones());
		inicializar();
	}
	private void mostrarResultados() {
		PeticionDTO p = peticiones.obtenerPeticion(tablePeticiones.getSelectedRow());
		if(p.getResultados().stream().anyMatch(r -> r.getTipoValCri() == TipoValorCritico.Reservado)) {
			JOptionPane.showMessageDialog(null,"RETIRAR POR SUCURSAL");
		}else {
			ResultadoPeticionview1 dialog = new ResultadoPeticionview1(frame,p,peticiones);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)tableModelPeticion.refresh();
		}
	}

	
	private void visualizarCriticos(boolean selected) {
		if(selected) {
			tableModelPeticion.setListaPeticiones(peticiones.listaPeticionesResCriticos());
			
		} else {
			tableModelPeticion.setListaPeticiones(peticiones.listaPeticiones());
			
		}
	}
	private void inicializar() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(PeticionABM.class.getResource("/res/hospital4.png")));
		setTitle("ABM Peticiones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 863, 542);
		peticionPanel = new JPanel();
		peticionPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(peticionPanel);

		panel_1 = new JPanel();

		JScrollPane scrollPane = new JScrollPane();

		tablePeticiones = new JTable(tableModelPeticion);
		tablePeticiones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
		          	mostrarResultados();
				}
		});
		tablePeticiones.setAutoCreateRowSorter(true);
		tablePeticiones.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tablePeticiones);

		chbxResultadosCriticos = new JCheckBox("Ver peticiones con resultados criticos");
		chbxResultadosCriticos.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				visualizarCriticos(((JCheckBox) e.getItem()).isSelected());
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Usted no tiene permiso para acceder");
			}
		});

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Usted no tiene permiso para acceder");
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Usted no tiene permiso para acceder");

			}
		});
		peticionPanel.setLayout(new BorderLayout(0, 0));
		
				JPanel panel = new JPanel();
				peticionPanel.add(panel, BorderLayout.NORTH);
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBorder(new EmptyBorder(10, 0, 0, 0));
				
						JLabel lblPeticiones = new JLabel("ABM Peticiones");
						lblPeticiones.setVerticalAlignment(SwingConstants.TOP);
						lblPeticiones.setForeground(Color.DARK_GRAY);
						lblPeticiones.setFont(new Font("Verdana", Font.PLAIN, 20));
						lblPeticiones.setBackground(Color.DARK_GRAY);
						GroupLayout gl_panel = new GroupLayout(panel);
						gl_panel.setHorizontalGroup(
							gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblPeticiones)
									.addContainerGap(674, Short.MAX_VALUE))
						);
						gl_panel.setVerticalGroup(
							gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPeticiones)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						);
						panel.setLayout(gl_panel);
		peticionPanel.add(scrollPane, BorderLayout.CENTER);
		peticionPanel.add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		JLabel lblNota = new JLabel("Para ver los resultados dobleclick en la peticion");
		lblNota.setHorizontalAlignment(SwingConstants.LEFT);
		lblNota.setForeground(Color.RED);
		lblNota.setFont(new Font("Verdana", Font.ITALIC, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(btnAgregar)
					.addGap(5)
					.addComponent(btnModificar)
					.addGap(5)
					.addComponent(btnEliminar)
					.addGap(5)
					.addComponent(chbxResultadosCriticos)
					.addGap(5)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
					.addComponent(lblNota)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(btnAgregar))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(btnModificar))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(btnEliminar))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(chbxResultadosCriticos)
								.addComponent(lblNota)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(2))
		);
		panel_1.setLayout(gl_panel_1);

	}
}
