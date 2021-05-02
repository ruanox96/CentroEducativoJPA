package gui;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Principal extends JFrame {

	private JTabbedPane jTabbedPane = null;
	
	private static Principal instance = null;
	
	/**
	 * 
	 * @return
	 */
	public static Principal getInstance () {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public Principal() {
		super("Datos");
		this.setBounds(0, 0, 700, 400);
		
		this.setJMenuBar(new MenuBar());
		
		this.setLayout(new BorderLayout());
		this.add(getPanelPrincipal(), BorderLayout.CENTER);
	}

	/**
	 * 
	 * @return
	 */
	private JTabbedPane getPanelPrincipal() {
		jTabbedPane = new JTabbedPane();
		
		jTabbedPane.add("Estudiante", new PanelEstudiantes());
		jTabbedPane.add("Profesores", new PanelProfesores());
		
		
		return jTabbedPane;
	}
	
	
	
	
	
	/**
	 * @return the jTabbedPane
	 */
	public JTabbedPane getjTabbedPane() {
		return jTabbedPane;
	}


	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Principal.getInstance().setVisible(true);
	}

}
