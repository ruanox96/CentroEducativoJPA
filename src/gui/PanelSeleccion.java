package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import model.Estudiante;

public class PanelSeleccion extends JPanel {
	private JLabel lblNombre;
	private JTextField jtfNota;
	Estudiante est = new Estudiante();

	/**
	 * Create the panel.
	 */
	public PanelSeleccion() {
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 136, 152, 0 };
		gbl_panel.rowHeights = new int[] { 38, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblNombre = new JLabel(
				this.est.getNombre() + " " + this.est.getApellido1() + " " + this.est.getApellido2() + " : ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNombre, gbc_lblNewLabel);

		JTextField jtfNota = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 0;
		panel.add(jtfNota, gbc_textField_3);
		jtfNota.setColumns(10);
		cargarActualEnPantalla();

	}
	private void cargarActualEnPantalla() {
		if (this.est != null) {
			this.lblNombre.setText(this.est.getNombre() + " " + this.est.getApellido1() + " " + this.est.getApellido2());
		}

	}

	/**
	 * 
	 * @return
	 */
	public Estudiante getEst() {
		return est;
	}

	/**
	 * 
	 * @param est
	 */
	public void setEst(Estudiante est) {
		this.est = est;
	}

}
