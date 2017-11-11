package interfaces;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Window;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Principal extends JPanel implements ActionListener{
	JButton salir;
	JButton cemp;
	JButton eemp;
	JButton memp;
	public Principal() {
		initUI();
	}

		private void initUI() {
			 
			
			eemp=new JButton("Eliminar Empleado");
			eemp.setBounds(300,250,100,30);
	 		add(eemp);
	 		eemp.addActionListener(this);
	 		
	 		memp=new JButton("Modificar Empleado");
	 		memp.setBounds(300,250,100,30);
	 		add(memp);
	 		memp.addActionListener(this);
	 		
			cemp=new JButton("Crear Empleado");
			cemp.setBounds(300,250,100,30);
	 		add(cemp);
	 		cemp.addActionListener(this);
	 		
			salir=new JButton("Salir Del Programa");
		 		salir.setBounds(300,250,100,30);
		 		add(salir);
		 		salir.addActionListener(this);
		}
				
		private void createButtons(String button1, String button2) {

			Box box = Box.createHorizontalBox();
			box.add(Box.createHorizontalGlue());
			box.add(new JButton(button1));
			box.add(Box.createHorizontalStrut(10));
			box.add(new JButton(button2));
			box.add(Box.createHorizontalStrut(10));		
			add(box);
		}
		
		private void createButton(String button1) {

			Box box = Box.createHorizontalBox();
			box.add(Box.createHorizontalGlue());
			box.add(new JButton(button1));
			box.add(Box.createHorizontalStrut(10));		
			add(box);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==salir) {
	            System.exit(0);
	        }
			else if (e.getSource()==cemp){
				Window w = SwingUtilities.getWindowAncestor(this);
				JFrame frame = new JFrame("Correo");
				frame.setTitle("Alta");
				frame.setSize(300, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(new Alta());
				frame.setVisible(true);
				w.dispose();
				
			}
			else if (e.getSource()==eemp){
				Window w = SwingUtilities.getWindowAncestor(this);
				JFrame frame = new JFrame("Correo");
				frame.setTitle("Baja");
				frame.setSize(300, 500);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().add(new Baja());
				frame.setVisible(true);
				w.dispose();
			}
			else if (e.getSource()==memp){
				Handler.modificacion();
				/* Window w = SwingUtilities.getWindowAncestor(this);
				w.dispose(); */
			}
			
		}
}