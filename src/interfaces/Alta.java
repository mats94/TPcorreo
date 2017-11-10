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

public class Alta extends JPanel implements ActionListener{
	JButton salir;
	public Alta() {
		initUI();
	}

		private void initUI() {
			// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			createLabelTextfield("Nombre :", 10);
			createLabelTextfield("Apellido :", 10);
			createLabelTextfield("Peso :", 10);
			createLabelTextfield("Tipo de envio :", 10);
			createLabelTextfield("Modalidad de envio :", 10);
			createLabelTextfield("Destino :", 10);
			createLabelTextfield("Origen :", 10);
			createButton("Enviar formulario");
			createButton("Volver al menu principal");
			createButtonExit("Salir Del Programa");
			/*salir=new JButton("Salir Del Programa");
			 	salir.setBounds(300,250,100,30);
			 	add(salir);
			 	salir.addActionListener(this); */
		}
		private void createLabelTextfield(String campo,int capacidad) {
			
			Box box = Box.createHorizontalBox();
			box.add(Box.createHorizontalStrut(30));
			box.add(new JLabel(campo));
			box.add(Box.createHorizontalStrut(10));
			box.add(wrapTextfield(new JTextField(capacidad)));
			box.add(Box.createHorizontalStrut(20));
			setBackground(new Color(0, 200, 0));
			this.add(box);
		}
		private Component wrapTextfield(JTextField textField) {
			JPanel aux = new JPanel();
			aux.add(textField);
			return aux;
		}
		
		private void createButton(String button1) {

			Box box = Box.createHorizontalBox();
			box.add(Box.createHorizontalGlue());
			box.add(new JButton(button1));
			box.add(Box.createHorizontalStrut(10));		
			add(box);
		}
		private void createButtonExit(String button1) {

			Box box = Box.createHorizontalBox();
			box.add(Box.createHorizontalGlue());
			JButton boton = new JButton(button1);
			boton.addActionListener(this);
			box.add(boton);
			box.add(Box.createHorizontalStrut(10));		
			add(box);
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
			
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==salir) {
	            System.exit(0);
	        }
			else {
				JFrame frame = new JFrame("Correo");
				Window w = SwingUtilities.getWindowAncestor(this);
				  frame.setTitle("Menu Principal");
				  frame.setSize(300, 500);
				  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				  frame.getContentPane().add(new Principal());
				  frame.setVisible(true);
				  w.dispose();
			}
			
		}
}
