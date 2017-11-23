package interfaces;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Pedido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Baja extends JPanel implements ActionListener{
	private JButton salir;
	private JButton volver;
	private JButton enviar;
	private Handler myhandler;
	private JTextField apellido;
	private JTextField nombre;
	public Baja(Handler handler) {
		
			myhandler = handler;
			Box box = Box.createVerticalBox();
			
			nombre = new JTextField(10);
			apellido = new JTextField(10);
			
			box.add(createLabelTextfield("Nombre del cliente:", nombre));
			
			box.add(Box.createVerticalStrut(10));
			
			box.add(createLabelTextfield("Apellido del cliente:", apellido));
			
			box.add(Box.createVerticalStrut(10));
						
			enviar=new JButton("Enviar formulario");
			enviar.setBounds(300,250,100,30);
		 	box.add(enviar);
		 	enviar.addActionListener(this);
			
			box.add(Box.createVerticalStrut(20));
							
			volver=new JButton("Volver al menu principal");
			volver.setBounds(300,250,100,30);
		 	box.add(volver);
		 	volver.addActionListener(this);
			
		 	box.add(Box.createVerticalStrut(30));
		 	
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
				
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==salir) {
	            System.exit(0);
			}
	        else if (e.getSource()==volver){	
	        	myhandler.principalframe();
			}
	        else if (e.getSource()==enviar){
				String apellido;
				String nombre;
				
				apellido = this.apellido.getText();
				nombre = this.nombre.getText();
				
				Pedido u = new Pedido();
				
				u.setNombre(nombre);
				u.setApellido(apellido);
	    
		        myhandler.mandardatos(u);
			}
			
		}
		
	}