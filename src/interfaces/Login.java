package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class Login extends JFrame implements ActionListener
{
 JButton entrar;
 JPanel panel;
 JLabel label1,label2;
 final JTextField  text1,text2;
 Handler myhandler;
  Login(Handler handler)
  {
	  myhandler = handler;
	  panel=new JPanel();
	  add(panel,BorderLayout.CENTER);
	  setTitle("LOGIN");
  
	  label1 = new JLabel();
	  label1.setText("Usuario:");
	  panel.add(label1);
  
	  text1 = new JTextField(15);
	  panel.add(text1);
  
	  label2 = new JLabel();
	  label2.setText("Password:");
	  panel.add(label2);
  
	  text2 = new JPasswordField(15);
	  panel.add(text2);
 
	  entrar=new JButton("Entrar");
	  panel.add(entrar);
  
	  entrar.addActionListener(this);
  
  }

  public void actionPerformed(ActionEvent ae){
	  String value1=text1.getText();
	  String value2=text2.getText();
	  
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
  		JOptionPane.showMessageDialog(this,msj, 
				  "ERROR",JOptionPane.ERROR_MESSAGE);
  	}
}
