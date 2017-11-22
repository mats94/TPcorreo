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
	private JButton salir;
	private JButton volver;
	private Handler myhandler;
	public Alta(Handler handler) {
		
			myhandler = handler;
			createLabelTextfield("Nombre :", 10);
			createLabelTextfield("Apellido :", 10);
			createLabelTextfield("Peso :", 10);
			createLabelTextfield("Tipo de envio :", 10);
			createLabelTextfield("Modalidad de envio :", 10);
			createLabelTextfield("Destino :", 10);
			createLabelTextfield("Origen :", 10);
			createButton("Enviar formulario");

			volver=new JButton("Volver al menu principal");
			volver.setBounds(300,250,100,30);
		 	add(volver);
		 	volver.addActionListener(this);
			
			salir=new JButton("Salir Del Programa");
				salir.setBounds(300,250,100,30);
				add(salir);
				salir.addActionListener(this);
			
			
		}
		private void createLabelTextfield(String campo,int capacidad) {
			
			Box box = Box.createHorizontalBox();
			box.add(Box.createHorizontalStrut(30));
			box.add(new JLabel(campo));
			box.add(Box.createHorizontalStrut(10));
			box.add(wrapTextfield(new JTextField(capacidad)));
			box.add(Box.createHorizontalStrut(20));
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
			else if (e.getSource()==volver){	
		        myhandler.principalframe();
			}
			
		}
}
