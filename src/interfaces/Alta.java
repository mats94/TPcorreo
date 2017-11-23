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

import entidades.Pedido;

public class Alta extends JPanel implements ActionListener{
	private JButton salir;
	private JButton volver;
	private JButton enviar;
	private Handler myhandler;
	public Alta(Handler handler) {
		
			myhandler = handler;
			
			Box box = Box.createVerticalBox();
			JTextField nombre = new JTextField(10);
			box.add(createLabelTextfield("Nombre :", nombre));
			box.add(createLabelTextfield("Apellido :", 10));
			box.add(createLabelTextfield("Peso :", 10));
			box.add(createLabelTextfield("Tipo de envio :", 10));
			box.add(createLabelTextfield("Modalidad de envio :", 10));
			box.add(createLabelTextfield("Destino :", 10));
			box.add(createLabelTextfield("Origen :", 10));
			
			enviar=new JButton("Enviar formulario");
			enviar.setBounds(300,250,100,30);
		 	box.add(enviar);
		 	enviar.addActionListener(this);

			volver=new JButton("Volver al menu principal");
			volver.setBounds(300,250,100,30);
		 	box.add(volver);
		 	volver.addActionListener(this);
			
			salir=new JButton("Salir Del Programa");
			salir.setBounds(300,250,100,30);
			box.add(salir);
			salir.addActionListener(this);
			
			add(box);
			
		}
		private Box createLabelTextfield(String campo,JTextField textfield) {
			
			Box box = Box.createHorizontalBox();
			box.add(Box.createHorizontalStrut(30));
			box.add(new JLabel(campo));
			box.add(Box.createHorizontalStrut(10));
			box.add(wrapTextfield(textfield));
			box.add(Box.createHorizontalStrut(20));
			return box;
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
			else if (e.getSource()==enviar){
				Pedido u = new Pedido();
		        myhandler.mandardatos(u);
			}
			
		}
}
