package interfaces;

import java.awt.event.*;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import entidades.Pedido;

public class Alta extends JPanel implements ActionListener{
	private JButton salir;
	private JButton volver;
	private JButton enviar;
	private Handler myhandler;
	private JTextField apellido;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField direccion;
	private JTextField estado;
	private JTextField destino;
	
	public Alta(Handler handler) {
		
			myhandler = handler;
			
			Box box = Box.createVerticalBox();
			nombre = new JTextField(10);
			apellido = new JTextField(10);
			telefono = new JTextField(10);
			direccion = new JTextField(10);
			estado = new JTextField(10);
			destino = new JTextField(10);

			box.add(createLabelTextfield("Nombre :", nombre));
			box.add(createLabelTextfield("Apellido :", apellido));
			box.add(createLabelTextfield("direccion :", direccion));
			box.add(createLabelTextfield("Telefono :", telefono));
			box.add(createLabelTextfield("Destino :", destino));
			box.add(createLabelTextfield("Estado de envio :", estado));
			
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
				String telefono;
				String direccion;
				String estado;
				String destino;
				
				apellido = this.apellido.getText();
				nombre = this.nombre.getText();
				telefono = this.telefono.getText();
				direccion = this.direccion.getText();
				estado = this.estado.getText();
				destino = this.destino.getText();
				
				Pedido u = new Pedido();
				
				u.setNombre(nombre);
				u.setApellido(apellido);
				u.setTelefono(telefono);
				u.setDireccion(direccion);
				u.setEstado(estado);
				u.setDestino(destino);
			    
			    
		        myhandler.mandardatos(u);
			}
			
		}
}