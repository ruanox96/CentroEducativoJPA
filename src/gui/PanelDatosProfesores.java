package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;

public class PanelDatosProfesores extends JPanel {

	pnlDatosPersonales pnlDatosPersonales = new pnlDatosPersonales();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PanelDatosProfesores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(pnlDatosPersonales, gbc_lblNewLabel);
	}

}
