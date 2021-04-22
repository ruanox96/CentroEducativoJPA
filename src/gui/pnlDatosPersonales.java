package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class pnlDatosPersonales extends JPanel {
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDir;
	private JTextField jtfEmail;
	private JTextField jtfTel;

	
	/**
	 * Create the panel.
	 */
	public pnlDatosPersonales() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 0;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 1;
		add(lblApellido, gbc_lblApellido);
		
		jtfApellido1 = new JTextField();
		jtfApellido1.setColumns(10);
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 1;
		add(jtfApellido1, gbc_jtfApellido1);
		
		JLabel lblApellido_1 = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblApellido_1 = new GridBagConstraints();
		gbc_lblApellido_1.anchor = GridBagConstraints.EAST;
		gbc_lblApellido_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido_1.gridx = 0;
		gbc_lblApellido_1.gridy = 2;
		add(lblApellido_1, gbc_lblApellido_1);
		
		jtfApellido2 = new JTextField();
		jtfApellido2.setColumns(10);
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 2;
		add(jtfApellido2, gbc_jtfApellido2);
		
		JLabel lblDni = new JLabel("Dni:");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 3;
		add(lblDni, gbc_lblDni);
		
		jtfDni = new JTextField();
		jtfDni.setColumns(10);
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 3;
		add(jtfDni, gbc_jtfDni);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.EAST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 0;
		gbc_lblDireccin.gridy = 4;
		add(lblDireccin, gbc_lblDireccin);
		
		jtfDir = new JTextField();
		jtfDir.setColumns(10);
		GridBagConstraints gbc_jtfDir = new GridBagConstraints();
		gbc_jtfDir.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDir.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDir.gridx = 1;
		gbc_jtfDir.gridy = 4;
		add(jtfDir, gbc_jtfDir);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 5;
		add(jtfEmail, gbc_jtfEmail);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblTelfono = new GridBagConstraints();
		gbc_lblTelfono.anchor = GridBagConstraints.EAST;
		gbc_lblTelfono.insets = new Insets(0, 0, 0, 5);
		gbc_lblTelfono.gridx = 0;
		gbc_lblTelfono.gridy = 6;
		add(lblTelfono, gbc_lblTelfono);
		
		jtfTel = new JTextField();
		jtfTel.setColumns(10);
		GridBagConstraints gbc_jtfTel = new GridBagConstraints();
		gbc_jtfTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTel.gridx = 1;
		gbc_jtfTel.gridy = 6;
		add(jtfTel, gbc_jtfTel);

	}
	public String getNombre() {
		return this.jtfNombre.getText();
	}
	public void setNombre(String nombre) {
		this.jtfNombre.setText(nombre);
	}
	public String getApellido1() {
		return this.jtfApellido1.getText();
	}
	public void setApellido1(String apellido1) {
		this.jtfApellido1.setText(apellido1);
	}
	public String getApellido2() {
		return this.jtfApellido2.getText();
	}
	public void setApellido2(String apellido2) {
		this.jtfApellido2.setText(apellido2);
	}
	public String getDni() {
		return this.jtfDni.getText();
	}
	public void setDni(String dni) {
		this.jtfDni.setText(dni);
	}
	public String getDir() {
		return this.jtfDir.getText();
	}
	public void setDir(String dir) {
		this.jtfDni.setText(dir);
	}
	public String getEmail() {
		return this.jtfEmail.getText();
	}
	public void setEmail(String email) {
		this.jtfEmail.setText(email);
	}
	public String getTelefono() {
		return this.jtfTel.getText();
	}
	public void setTelefono(String telefono) {
		this.jtfTel.setText(telefono);
	}

}
