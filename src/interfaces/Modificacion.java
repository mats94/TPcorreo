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

public class Modificacion extends JPanel implements ActionListener{
	private JButton salir;
	private JButton volver;
	private JButton enviar;
	private JButton verif;
	private Handler myhandler;
	public Modificacion(Handler handler) {
	
			myhandler = handler;
			
			Box box = Box.createVerticalBox();
			
			box.add(createLabelTextfield("Nombre del cliente:", 10));
			box.add(createLabelTextfield("Documento:", 10));
			box.add(Box.createVerticalStrut(10));
			
			verif=new JButton("Verificar");
			verif.setBounds(300,250,100,30);
		 	box.add(verif);
		 	verif.addActionListener(this);
		 	box.add(Box.createVerticalStrut(10));
		 	
			box.add(createLabelTextfield("Nuevo nombre:", 10));
			box.add(createLabelTextfield("Nuevo Peso:", 10));
			box.add(createLabelTextfield("Nuevo Tipo de envio:", 10));
			box.add(createLabelTextfield("Nuevo origen:", 10));
			box.add(createLabelTextfield("Nuevo destino:", 10));
			
			box.add(Box.createVerticalStrut(20));
			
			enviar=new JButton("Enviar formulario");
			enviar.setBounds(300,250,100,30);
		 	box.add(enviar);
		 	enviar.addActionListener(this);
			
		 	box.add(Box.createVerticalStrut(20));
		 	
			volver=new JButton("Volver al menu principal");
			volver.setBounds(300,250,100,30);
		 	box.add(volver);
		 	volver.addActionListener(this);
			
		 	box.add(Box.createVerticalStrut(20));
		 	
			salir=new JButton("Salir Del Programa");
			salir.setBounds(300,250,100,30);
			box.add(salir);
			salir.addActionListener(this);
				
			add(box);
		}
	    
		private Box createLabelTextfield(String campo,int capacidad) {
			Box box = Box.createHorizontalBox();
			box.add(Box.createHorizontalStrut(30));
			box.add(new JLabel(campo));
			box.add(Box.createHorizontalStrut(10));
			box.add(wrapTextfield(new JTextField(capacidad)));
			box.add(Box.createHorizontalStrut(20));
			return box;

		}
		private Component wrapTextfield(JTextField textField) {
			JPanel aux = new JPanel();
			aux.add(textField);
			return aux;
		}
		
		
		private Box createButton(String button1) {

			Box box = Box.createHorizontalBox();
			box.add(Box.createHorizontalGlue());
			box.add(new JButton(button1));
			box.add(Box.createHorizontalStrut(10));	
			return box;
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