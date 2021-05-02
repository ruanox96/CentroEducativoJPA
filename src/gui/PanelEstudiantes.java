package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import model.Estudiante;
import model.Tipologiasexo;
import model.entities.controllers.ControladorEstudiantes;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class PanelEstudiantes extends JPanel {
	Panel p = new Panel();
	Estudiante actual = new Estudiante();

	public PanelEstudiantes() {
		super();
		initialize();
		this.actual = ControladorEstudiantes.getInstance().findPrimero();
		cargarActualEnPantalla();
	}
	
	public void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.gridwidth = 3;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                actual = ControladorEstudiantes.getInstance().findPrimero();
                cargarActualEnPantalla();
            }
        });
		btnPrimero.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/fotos/primero.png")));
		toolBar.add(btnPrimero);
		
		
		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/fotos/patras.png")));
		toolBar.add(btnAnterior);
		btnAnterior.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
            actual = ControladorEstudiantes.getInstance().findAnterior(actual.getId());
            cargarActualEnPantalla();
        }
    });
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/fotos/siguiente.png")));
		toolBar.add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            actual = ControladorEstudiantes.getInstance().findSiguiente(actual.getId());
	            cargarActualEnPantalla();
	        }
	    });
		JButton btnUltimo = new JButton("");
		btnUltimo.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/fotos/final.png")));
		toolBar.add(btnUltimo);
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            actual = ControladorEstudiantes.getInstance().findUltimo();
	            cargarActualEnPantalla();
	        }
	    });
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/fotos/guardar.png")));
		toolBar.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            
					guardar();
	        }
	    });
		
		JButton btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/fotos/nuevo.png")));
		toolBar.add(btnNuevo);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					vaciarCampos();
	        }
	    });
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setIcon(new ImageIcon(PanelEstudiantes.class.getResource("/fotos/borrar.jpg")));
		toolBar.add(btnBorrar);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            borrar();
	            vaciarCampos();
	        }
	    });
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(p, gbc_lblNewLabel);
	}
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.p.setNombre(this.actual.getNombre());
			this.p.setApellido1(this.actual.getApellido1());
			this.p.setApellido2(this.actual.getApellido2());
			this.p.setDni(this.actual.getDni());
			this.p.setDireccion(this.actual.getDireccion());
			this.p.setEmail(this.actual.getEmail());
			this.p.setTelefono(this.actual.getTelefono());

			for (int i = 0; i < this.p.getJcbsexo().getItemCount(); i++) {
				if (this.actual.getTipologiasexo().getId() == this.p.getJcbsexo().getItemAt(i)
						.getId()) {
					this.p.getJcbsexo().setSelectedIndex(i);

				}
			}
			this.p.setColor(this.actual.getColorFavorito());
			this.p.setImagen(this.actual.getImagen());
			this.p.setlabelDimensiones(calculaPixeles());

		}
		
		
	}
	
	private String calculaPixeles () {

        String str = "";
        InputStream is = new ByteArrayInputStream( this.actual.getImagen());

        try {
            BufferedImage newBi = ImageIO.read(is);
             str = newBi.getWidth() + " x " + newBi.getHeight() + " píxeles";

        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }

	private void cargarActualDesdePantalla() {
		this.actual.setNombre(this.p.getNombre());
		this.actual.setApellido1(this.p.getApellido1());
		this.actual.setApellido2(this.p.getApellido2());
		this.actual.setDni(this.p.getDni());
		this.actual.setDireccion(this.p.getDireccion());
		this.actual.setEmail(this.p.getEmail());
		this.actual.setTelefono(this.p.getTelefono());
		Tipologiasexo t = (Tipologiasexo) this.p.getJcbsexo().getSelectedItem();
		this.actual.setTipologiasexo(t);
		this.actual.setColorFavorito(this.p.getColor());
	}
	
	

	/**
	 * 
	 */
	private void vaciarCampos() {
		this.actual.setId(0);
		this.p.jtfNombre.setText("");
		this.p.jtfApellido1.setText("");
		this.p.jtfApellido2.setText("");
		this.p.jtfDni.setText("");
		this.p.jtfDir.setText("");
		this.p.jtfTel.setText("");
		this.p.jtfEmail.setText("");
		this.p.jcbSexo.setSelectedItem(null);
		this.p.setColor(null);
		this.p.jtfColor.setText("");
		this.p.setLabelImag("");
	}

	/**
	 * 
	 */
	private void guardar() {
		cargarActualDesdePantalla();
		boolean resultado = ControladorEstudiantes.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null && this.actual.getId() > 0) {
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}

	private void borrar() {
		String posiblesRespuestas[] = { "Sí", "No" };
		// En esta opci�n se utiliza un showOptionDialog en el que personalizo el icono
		// mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Gestión Centro Educativo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas,
				posiblesRespuestas[1]);
		if (opcionElegida == 0) {
			ControladorEstudiantes.getInstance().borrar(this.actual);
			vaciarCampos();
		}
	}
	
	
}
