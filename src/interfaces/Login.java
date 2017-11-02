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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel implements ActionListener{
	JButton salir;
	JButton entrar;
	JLabel userLabel;
	JTextField userText;
	JLabel passwordLabel;
	JPasswordField passwordText;
	JButton loginButton;
	public Login() {
		initUI();
	}

		private void initUI() {
	

			
			JLabel userLabel = new JLabel("Usuario:  ");
			userLabel.setBounds(10, 10, 70, 25);
			add(userLabel);

			JTextField userText = new JTextField(20);
			userText.setBounds(100, 10, 160, 25);
			add(userText);

			JLabel passwordLabel = new JLabel("Password:");
			passwordLabel.setBounds(10, 40, 80, 25);
			add(passwordLabel);

			JPasswordField passwordText = new JPasswordField(20);
			passwordText.setBounds(100, 40, 160, 25);
			add(passwordText);

			
			entrar=new JButton("Entrar");
			entrar.setBounds(300,250,100,30);
		 	add(entrar);
		 	entrar.addActionListener(this);

			
			salir=new JButton("Salir");
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
		
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==salir) {
	            System.exit(0);
			}
	        else if (e.getSource()==entrar){
					
					
	        	    JFrame frame = new JFrame("Correo");
					frame.setTitle("Menu Principal");
					frame.setSize(300, 500);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
					frame.getContentPane().add(new Principal());
					frame.setVisible(true);
					
					
				}
			
		}
}
