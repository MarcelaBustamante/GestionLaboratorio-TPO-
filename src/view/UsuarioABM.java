package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import view.ModalResult;
import view.tablemodel.UsuarioTableModel;

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

import collections.UsuarioCollection;
import controller.UsuarioController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;

public class UsuarioABM extends JFrame {
	private UsuarioController usuarios;
	private JFrame frame;
	private JPanel usuarioPanel;
	private JPanel panel_1;
	private JTable tableUsuarios;
	private UsuarioTableModel tableModelUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioABM window = new UsuarioABM();
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
	public UsuarioABM() {
		usuarios = new UsuarioController();
		tableModelUsuario = new UsuarioTableModel(usuarios.listaUsuarios());
		inicializar();
	}

	private void agregarUsuario() {
		try {
			//abre un alta de peticion
			AltaUsuario dialog = new AltaUsuario(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			JOptionPane.showMessageDialog(null, "Finalizado");
			if (dialog.getModalResult() == ModalResult.OK)
				tableModelUsuario.agregar(dialog.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	private void modificar() {
		try {
			AltaUsuario dialog = new AltaUsuario(frame);
			dialog.setUsuario(usuarios.obtenerUsuario((tableUsuarios.getSelectedRow())));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			JOptionPane.showMessageDialog(null, "El usuario ha sido modificado");
			if (dialog.getModalResult() == ModalResult.OK)
				tableModelUsuario.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void eliminar() {
		usuarios.eliminarUsuario(tableUsuarios.getSelectedRow());
		JOptionPane.showMessageDialog(frame, "El usuario ha sido eliminado");
		tableModelUsuario.refresh();
	}
	private void inicializar() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}				
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(UsuarioABM.class.getResource("/res/hospital4.png")));
		setTitle("ABM Usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 811, 563);
		usuarioPanel = new JPanel();
		usuarioPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(usuarioPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		panel_1 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_usuarioPanel = new GroupLayout(usuarioPanel);
		gl_usuarioPanel.setHorizontalGroup(
			gl_usuarioPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_usuarioPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
		);
		gl_usuarioPanel.setVerticalGroup(
			gl_usuarioPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_usuarioPanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
		);
		
		tableUsuarios = new JTable(tableModelUsuario);
		tableUsuarios.setAutoCreateRowSorter(true);
		tableUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tableUsuarios);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarUsuario();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		JSeparator separator = new JSeparator();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnAgregar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnModificar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEliminar))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(15)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminar)
						.addComponent(btnModificar)
						.addComponent(btnAgregar))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblUsuarios = new JLabel("ABM Usuarios");
		panel.add(lblUsuarios);
		lblUsuarios.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblUsuarios.setBackground(Color.DARK_GRAY);
		usuarioPanel.setLayout(gl_usuarioPanel);
		
	}
	
}
