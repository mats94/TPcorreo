package interfaces;

import java.awt.event.*;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import entidades.Pedido;
import entidades.Usuario;

public class AltaUsuario extends JPanel implements ActionListener{
	private JButton salir;
	private JButton volver;
	private JButton guardar;
	private Handler myhandler;
	private JTextField apellido;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField direccion;
	private JTextField tipo;
	private JTextField usuario;
	private JTextField password;
	
	public AltaUsuario(Handler handler) {
		
			myhandler = handler;
			
			Box box = Box.createVerticalBox();
			usuario = new JTextField(10);
			password = new JTextField(10);
			nombre = new JTextField(10);
			apellido = new JTextField(10);
			telefono = new JTextField(10);
			direccion = new JTextField(10);
			tipo = new JTextField(10);
			
			box.add(createLabelTextfield("Usuario :", usuario));
			box.add(createLabelTextfield("Password :", password));
			box.add(createLabelTextfield("Nombre :", nombre));
			box.add(createLabelTextfield("Apellido :", apellido));
			box.add(createLabelTextfield("direccion :", direccion));
			box.add(createLabelTextfield("Telefono :", telefono));
			box.add(createLabelTextfield("Tipo :", tipo));
			
			box.add(Box.createVerticalStrut(20));
			
			guardar=new JButton("Guardar Usuario");
			guardar.setBounds(300,250,100,30);
		 	box.add(guardar);
		 	guardar.addActionListener(this);
		 	
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
		        myhandler.ManejoEnviosFrame();
			}
			else if (e.getSource()==guardar){
				String apellido;
				String nombre;
				String telefono;
				String direccion;
				String tipo;
				String usuario;
				String password;
				
				apellido = this.apellido.getText();
				nombre = this.nombre.getText();
				telefono = this.telefono.getText();
				direccion = this.direccion.getText();
				tipo = this.tipo.getText();
				if(tipo == "administrador" || tipo == "empleado" || tipo == "cliente") {
				usuario = this.usuario.getText();
				password = this.password.getText();
				
				Usuario u = new Usuario();
				
				u.setNombre(nombre);
				u.setApellido(apellido);
				u.setTelefono(telefono);
				u.setDireccion(direccion);
				u.setTipo(tipo);	
				u.setUsuario(usuario);
				u.setPassword(password);
			    
		        myhandler.guardarUsuario(u);
				}else {
					myhandler.mostrarERROR("tipo de usuario incorrecto");
				}
			}
			
		}
}