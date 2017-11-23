package interfaces;

import java.awt.event.*;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Principal extends JPanel implements ActionListener{
	
	JButton salir;
	JButton cemp;
	JButton eemp;
	JButton memp;
	Handler myhandler;
	
	public Principal(Handler handler){
		
			Box box = Box.createVerticalBox();

			myhandler = handler;
			eemp=new JButton("Eliminar Pedido");
			eemp.setBounds(300,250,100,30);
	 		box.add(eemp);
	 		eemp.addActionListener(this);
	 		
	 		box.add(Box.createVerticalStrut(10));

	 		memp=new JButton("Modificar Pedido");
	 		memp.setBounds(300,250,100,30);
	 		box.add(memp);
	 		memp.addActionListener(this);
	 		
	 		box.add(Box.createVerticalStrut(10));
	 		

			cemp=new JButton("Nuevo Pedido");
			cemp.setBounds(300,250,100,30);
	 		box.add(cemp);
	 		cemp.addActionListener(this);
	 		
	 		box.add(Box.createVerticalStrut(30));
	 		
			salir=new JButton("Salir Del Programa");
		 	salir.setBounds(300,250,100,30);
		 	box.add(salir);
		 	salir.addActionListener(this);
		
		 	add(box);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==salir) {
	            System.exit(0);
	        }
			else if (e.getSource()==cemp){
				myhandler.alta();		
			}
			else if (e.getSource()==eemp){
				myhandler.baja();
			}
			else if (e.getSource()==memp){
				myhandler.modificacion();
			}
			
		}
}