package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class Login extends JPanel implements ActionListener
{
 JButton entrar;
 JPanel panel;
 JLabel label1,label2;
 final JTextField  text1,text2;
  Login()
  {
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
		  JOptionPane.showMessageDialog(this,"Logiado exitosamente", 
				  "Correcto",JOptionPane.DEFAULT_OPTION);
		  
		 Handler.principalframe();
		 /* JFrame frame = new JFrame("Correo");
		  frame.setTitle("Menu Principal");
		  frame.setSize(300, 500);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		  frame.getContentPane().add(new Principal());
		  frame.setVisible(true);*/
		  this.dispose();}
		  else {
			  JOptionPane.showMessageDialog(this,"Datos incorrectos", 
					  "Incorrecto",JOptionPane.ERROR_MESSAGE);
		  }
	  }
}
