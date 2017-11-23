package interfaces;

import javax.swing.*;
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
	  box.add(createLabelTextfield("Contraseña :", pass));
	  
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
			
			if (value1.equals("admin") && value2.equals("admin")) {
				//JOptionPane.showMessageDialog(this,"Logiado exitosamente", 
				 // "Correcto",JOptionPane.DEFAULT_OPTION);
				myhandler.principalframe();
				//this.dispose();
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
			public void mostrarmsj(String msj) {
				JOptionPane.showMessageDialog(this,msj, "ERROR",JOptionPane.ERROR_MESSAGE);
  	}
}
