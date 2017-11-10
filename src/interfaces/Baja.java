package interfaces;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Baja extends JPanel implements ActionListener{
	JButton salir;
	JButton volver;
	public Baja() {
		initUI();
	}

		private void initUI() {
			createLabelTextfield("Nombre del cliente:", 10);
			createLabelTextfield("Documento:", 10);
			createButton("Buscar");
			createLabelTextfield("Motivo de la baja:", 10);
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
			setBackground(new Color(0, 200, 0));
			this.add(box);
		}
		private Component wrapTextfield(JTextField textField) {
			JPanel aux = new JPanel();
			aux.add(textField);
			return aux;
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
	        else if (e.getSource()==volver){
					
					JFrame frame = new JFrame("Correo");
					frame.setTitle("Menu Principal");
					frame.setSize(300, 500);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().add(new Principal());
					frame.setVisible(true);
					
					
				}
			}
	}





		
