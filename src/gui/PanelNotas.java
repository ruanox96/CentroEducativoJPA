package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Tipologiasexo;
import model.entities.controllers.ControladorMateria;
import model.entities.controllers.ControladorProfesores;

public class PanelNotas extends JPanel {
	private JScrollPane scrollPane;
	PanelSeleccion p = new PanelSeleccion();
	private JComboBox jcbMateria;
	private JComboBox jcbProfesor;
	private Materia actual = new Materia();
	
	

	/**
	 * Create the panel.
	 */
	public PanelNotas() {
		initialize();
		cargarDatos();

	}
		private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{73, 0, 99, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 53, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel.add(lblMateria, gbc_lblMateria);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 0, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);
		
		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 0, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JButton btnRefrescar = new JButton("Refrescar alumnado");
		GridBagConstraints gbc_btnRefrescar = new GridBagConstraints();
		gbc_btnRefrescar.gridx = 2;
		gbc_btnRefrescar.gridy = 1;
		panel.add(btnRefrescar, gbc_btnRefrescar);
		
		scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollAlumnos = new GridBagConstraints();
        gbc_scrollAlumnos.insets = new Insets(0, 0, 5, 0);
        gbc_scrollAlumnos.gridwidth = 3;
        gbc_scrollAlumnos.fill = GridBagConstraints.BOTH;
        gbc_scrollAlumnos.gridx = 0;
        gbc_scrollAlumnos.gridy = 2;
        add(scrollPane, gbc_scrollAlumnos);


        // se inserta un panel de un estudiante
        this.scrollPane.setViewportView(p);

        JButton btnGuardar = new JButton("Guardar las notas de todos los alumnos");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.gridx = 2;
        gbc_btnNewButton_1.gridy = 3;
        add(btnGuardar, gbc_btnNewButton_1);
        

	}
	
	private void cargarDatos() {
        List<Materia> materia = ControladorMateria.getInstance().findAll();

        for (Materia t : materia) {
            this.jcbMateria.addItem(t);
        }

        List<Profesor> profesor = ControladorProfesores.getInstance().findAll();

        for (Profesor t : profesor) {
            this.jcbProfesor.addItem(t);
        }

    }
}
	
	