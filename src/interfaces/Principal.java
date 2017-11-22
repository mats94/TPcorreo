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
	Handler myhandler;
	public Principal(Handler handler){
		
			Box box = Box.createVerticalBox();

			
			myhandler = handler;
			eemp=new JButton("Eliminar Empleado");
			eemp.setBounds(300,250,100,30);
	 		box.add(eemp);
	 		eemp.addActionListener(this);
	 		
	 		box.add(Box.createVerticalStrut(10));

	 		memp=new JButton("Modificar Empleado");
	 		memp.setBounds(300,250,100,30);
	 		box.add(memp);
	 		memp.addActionListener(this);
	 		
	 		box.add(Box.createVerticalStrut(10));
	 		

			cemp=new JButton("Crear Empleado");
			cemp.setBounds(300,250,100,30);
	 		box.add(cemp);
	 		cemp.addActionListener(this);
	 		
	 		box.add(Box.createVerticalStrut(30));
	 		
			salir=new JButton("Salir Del Programa");
		 	salir.setBounds(300,250,100,30);
		 	box.add(salir);
		 	salir.addActionListener(this);
		
		 	add(box);
		}
				
		private void createButtons(String button1, String button2) {

			Box box = Box.createVerticalBox();
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
				myhandler.alta();		
			}
			else if (e.getSource()==eemp){
				myhandler.baja();
			}
			else if (e.getSource()==memp){
				myhandler.modificacion();
			}
			
		}
}