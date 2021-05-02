package gui;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;


import model.Tipologiasexo;
import model.entities.controllers.ControladorTipologiaSexo;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Panel extends JPanel {
	
	public JComboBox<Tipologiasexo>jcbSexo;
	
	public JTextField jtfNombre;
	public JTextField jtfApellido1;
	public JTextField jtfApellido2;
	public JTextField jtfDni;
	public JTextField jtfDir;
	public JTextField jtfEmail;
	public JTextField jtfTel;
	public JLabel sexo;
	public JScrollPane scrollPane;
	public JButton btnSeleccionar;
	public JLabel lblColor;
	public JTextField jtfColor;
	public JButton btnColor;
	JColorChooser jcolor;
	String strColor;
	Color color;
	JFileChooser jfile;
	File fichero;
	
	private byte imagen [] = new byte [] {};
	
	JPopupMenu popup = getPopUpMenu();
	private JPopupMenu popupMenu;
	private JLabel lblDimensiones;
			
	

	
	/**
	 * Create the panel.
	 */
	public Panel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 400, 180, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 0;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		scrollPane = new JScrollPane();
		
		popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		lblDimensiones = new JLabel("New label");
		popupMenu.add(lblDimensiones);
		popupMenu.addSeparator();
        popupMenu.add(crearNuevoMenuItem("Cambiar imagen"));
        addPopup(scrollPane, popupMenu);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
//		scrollPane.addMouseListener(new MouseAdapter() {
//			 
//            @Override
//            public void mousePressed(MouseEvent e) {
//                showPopup(e);
//            }
// 
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                showPopup(e);
//            }
// 
//            /**
//             * Método llamado cuando se detecta el evento de ratón, mostrará el menú
//             * @param e
//             */
//            private void showPopup(MouseEvent e) {
//                if (e.isPopupTrigger()) {
//                    popup.show(e.getComponent(),
//                            e.getX(), e.getY());
//                }
//            }
//        });
		
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
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
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
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 2;
		add(jtfApellido2, gbc_jtfApellido2);
		
		sexo = new JLabel("Sexo:");
		GridBagConstraints gbc_sexo = new GridBagConstraints();
		gbc_sexo.anchor = GridBagConstraints.EAST;
		gbc_sexo.insets = new Insets(0, 0, 5, 5);
		gbc_sexo.gridx = 0;
		gbc_sexo.gridy = 3;
		add(sexo, gbc_sexo);
		
		jcbSexo = new JComboBox();
		GridBagConstraints gbc_jcbsexo = new GridBagConstraints();
		gbc_jcbsexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbsexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbsexo.gridx = 1;
		gbc_jcbsexo.gridy = 3;
		add(jcbSexo, gbc_jcbsexo);
		
		JLabel lblDni = new JLabel("Dni:");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 4;
		add(lblDni, gbc_lblDni);
		
		jtfDni = new JTextField();
		jtfDni.setColumns(10);
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 4;
		add(jtfDni, gbc_jtfDni);
		
		JLabel lblDireccin = new JLabel("Direccion:");
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.EAST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 0;
		gbc_lblDireccin.gridy = 5;
		add(lblDireccin, gbc_lblDireccin);
		
		jtfDir = new JTextField();
		jtfDir.setColumns(10);
		GridBagConstraints gbc_jtfDir = new GridBagConstraints();
		gbc_jtfDir.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDir.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDir.gridx = 1;
		gbc_jtfDir.gridy = 5;
		add(jtfDir, gbc_jtfDir);
		
		btnSeleccionar = new JButton("Seleccionar imagen");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaFichero();
			}
		});
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionar.gridx = 2;
		gbc_btnSeleccionar.gridy = 5;
		add(btnSeleccionar, gbc_btnSeleccionar);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		
		JLabel lblTelfono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelfono = new GridBagConstraints();
		gbc_lblTelfono.anchor = GridBagConstraints.EAST;
		gbc_lblTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelfono.gridx = 0;
		gbc_lblTelfono.gridy = 7;
		add(lblTelfono, gbc_lblTelfono);
		
		jtfTel = new JTextField();
		jtfTel.setColumns(10);
		GridBagConstraints gbc_jtfTel = new GridBagConstraints();
		gbc_jtfTel.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTel.gridx = 1;
		gbc_jtfTel.gridy = 7;
		add(jtfTel, gbc_jtfTel);
		
		lblColor = new JLabel("Color favorito");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 0, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 8;
		add(lblColor, gbc_lblColor);
		
		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 0, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 8;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		btnColor = new JButton("Seleccionar Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarColor();
			}
		});
		btnColor.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.gridx = 2;
		gbc_btnColor.gridy = 8;
		add(btnColor, gbc_btnColor);
		cargarDatos();

	}
	
	private void seleccionarColor() {
		color = jcolor.showDialog(null, "SEleccione un color", color.BLUE);
		if (color != null) {
            strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
            this.jtfColor.setText(strColor);
            setBackground(color);
        }
	}
	private void cargarDatos() {
        List<Tipologiasexo> sexo = ControladorTipologiaSexo.getInstance().findAll();

        for (Tipologiasexo t : sexo) {
            this.jcbSexo.addItem(t);
        }
    }
	
	private void seleccionaFichero() {
        this.jfile = new JFileChooser();

        // Configurando el componente

        // Establecimiento de la carpeta de inicio
        this.jfile.setCurrentDirectory(new File("C:\\"));

        // Tipo de selecci�n que se hace en el di�logo
        this.jfile.setFileSelectionMode(JFileChooser.FILES_ONLY); // S�lo selecciona ficheros

        this.jfile.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return "Archivos de texto *.jpg";
            }

            @Override
            public boolean accept(File f) {
                if (f.isFile() && f.getAbsolutePath().endsWith(".jpg"))
                    return true;
                return false;
            }
        });


        // Abro el di�logo para la elecci�n del usuario
        int seleccionUsuario = jfile.showOpenDialog(null);

        if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
            fichero =jfile.getSelectedFile();
            try {
                this.imagen = Files.readAllBytes(fichero.toPath());
            } catch (IOException e) {
                System.out.println("Error al leer el contenido del fichero binario");
                e.printStackTrace();
            }

            try {

                ImageIcon img = new ImageIcon(fichero.toString());
                JLabel lbl = new JLabel(img);
                this.scrollPane.setViewportView(lbl);




            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Error al abrir la imagen " + ex);

            }

        }

    }
	

	public JComboBox<Tipologiasexo> getJcbsexo() {
		return jcbSexo;
	}

	public void setJcbsexo(JComboBox<Tipologiasexo> jcbSexo) {
		this.jcbSexo = jcbSexo;
	}

	public String getNombre() {
		return jtfNombre.getText();
	}

	public void setNombre(String nombre) {
		this.jtfNombre.setText(nombre);
	}

	public String getApellido1() {
		return jtfApellido1.getText();
	}

	public void setApellido1(String apellido1) {
		this.jtfApellido1.setText(apellido1); 
	}

	public String getApellido2() {
		return jtfApellido2.getText();
	}

	public void setApellido2(String apellido2) {
		this.jtfApellido2.setText(apellido2);
	}

	public String getDni() {
		return jtfDni.getText();
	}

	public void setDni(String dni) {
		this.jtfDni.setText(dni); 
	}

	public String getDireccion() {
		return jtfDir.getText();
	}

	public void setDireccion(String direccion) {
		this.jtfDir.setText(direccion);
	}

	public String getEmail() {
		return jtfEmail.getText();
	}

	public void setEmail(String email) {
		this.jtfEmail.setText(email);
	}

	public String getTelefono() {
		return jtfTel.getText();
	}

	public void setTelefono(String telefono) {
		this.jtfTel.setText(telefono);
	}

	public String getColor () {
		return this.jtfColor.getText();
	}
	
	public JLabel getlblDimensiones() {
        return lblDimensiones;
    }
    public void setlabelDimensiones(String lblDimensiones) {
        this.lblDimensiones.setText(lblDimensiones);
    }

	public void setColor(String color) {
		if (color != null) {
            this.jtfColor.setText(color);
            this.setBackground(Color.decode(color));
        }
        else {
            this.setBackground(Color.gray);
        }
	}
	
	public void setStrColor(String color) {
		this.jtfColor.setText(color);
	}
	
	public void setImagen(byte imagen[]) {
        ImageIcon icon = new ImageIcon(imagen);
        JLabel lbl = new JLabel(icon);
        this.scrollPane.setViewportView(lbl);
        this.scrollPane.revalidate();
        this.scrollPane.repaint();
    }

    public byte[] getImagen() {
        return this.imagen;
    }

    public void setLabelImag (String str) {
        JLabel lbl = new JLabel(str);
        this.scrollPane.setViewportView(lbl);
    }
    
    private JPopupMenu getPopUpMenu () {
		JPopupMenu menu = new JPopupMenu();
		
		menu.add(crearNuevoMenuItem("Dimensiones"));
		menu.addSeparator();
		menu.add(crearNuevoMenuItem("Cambiar imagen"));
		
		return menu;
	}
    
    private JMenuItem crearNuevoMenuItem (String titulo) {
        JMenuItem item = new JMenuItem(titulo);
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (titulo == "Cambiar imagen") {
                	seleccionaFichero();
                }
            }
        });
        
        return item;
	}
   
	
	
	
	


	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
