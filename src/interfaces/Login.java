package interfaces;

import javax.swing.*;

import utils.TPException;

import java.awt.*;
import java.awt.event.*;
 
class Login extends JFrame implements ActionListener
{
 JButton entrar;
 JButton salir;
 JPanel panel;
 JLabel label1,label2;
 Handler myhandler;
 private JTextField pass;
 private JTextField user;
  Login(Handler handler)
  {
	  myhandler = handler;
	  
	  Box box = Box.createVerticalBox();
	  
	  user = new JTextField(10);
	  pass = new JPasswordField(10);
	   
	  panel=new JPanel();
	  add(panel,BorderLayout.CENTER);
	  setTitle("Administracion de pedidos");
  
	  box.add(createLabelTextfield("Nombre :", user));
	  box.add(createLabelTextfield("Contrasenia :", pass));
	  
	  box.add(Box.createVerticalStrut(20));
	  
	  entrar=new JButton("Entrar");
	  box.add(entrar);
	  
	  box.add(Box.createVerticalStrut(20));
	 	
	  salir=new JButton("Salir Del Programa");
	  box.add(salir);
	  salir.addActionListener(this);
	  
	  panel.add(box);
  
	  entrar.addActionListener(this);
  
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
	
		public void actionPerformed(ActionEvent ae){
			String value1=user.getText();
			String value2=pass.getText();
	  
			if (ae.getSource()==salir) {
	            System.exit(0);
	        }
			try {
			myhandler.authUser(value1, value2);
			}catch(TPException e) {
				if(e.getMensaje() == "empleado") {
					myhandler.ManejoEnviosFrame();
				}
				else if(e.getMensaje() == "administrador") {
					myhandler.AdministradorFrame();
				}
				else {
					myhandler.mostrarERROR("Usuario y password invalidos");
				}
			}
			if (value1.equals("test") && value2.equals("test")) {
				myhandler.ManejoEnviosFrame();

			}
			else if(value1.equals("admin") && value2.equals("admin")) {
				myhandler.AdministradorFrame();
			}
			else {
			  JOptionPane.showMessageDialog(this,"Datos incorrectos", 
					  "Incorrecto",JOptionPane.ERROR_MESSAGE);
			}
	  }
			public void cambio(JPanel nuevopanel) {
				panel.setVisible(false);
				panel.removeAll();
				panel = nuevopanel;
				panel.repaint();
				add(panel);
				panel.revalidate();
				panel.setVisible(true);
	  
  	}
			public void mostrarERROR(String msj) {
				JOptionPane.showMessageDialog(this,msj, "ERROR",JOptionPane.ERROR_MESSAGE);
  	}
			public void mostrarmsj(String msj) {
				JOptionPane.showMessageDialog(this,msj, "Correcto",JOptionPane.OK_OPTION);
  	}
}
