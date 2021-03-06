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
import utils.TPException;

public class ModificarUsuario extends JPanel implements ActionListener{
	private JButton salir;
	private JButton volver;
	private JButton enviar;
	private JButton verif;
	private Handler myhandler;
	private JTextField buscardireccion;
	private JTextField buscarnombre;
	private JTextField apellido;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField direccion;
	private JTextField tipo;
	public ModificarUsuario(Handler handler) {
	
			myhandler = handler;
			
			Box box = Box.createVerticalBox();
			buscarnombre = new JTextField(10);
			nombre = new JTextField(10);
			apellido = new JTextField(10);
			telefono = new JTextField(10);
			direccion = new JTextField(10);
			tipo = new JTextField(10);
			
			box.add(createLabelTextfield("Usuario:", buscarnombre));
			//box.add(createLabelTextfield("Apellido:", buscardireccion));
			
			box.add(Box.createVerticalStrut(10));
			
			verif=new JButton("Verificar");
			verif.setBounds(300,250,100,30);
		 	box.add(verif);
		 	verif.addActionListener(this);
		 	
		 	box.add(Box.createVerticalStrut(10));
		 	
			box.add(createLabelTextfield("Nuevo Nombre:", nombre));
			box.add(createLabelTextfield("Nuevo Apellido:", apellido));
			box.add(createLabelTextfield("Nueva Direccion:", direccion));
			box.add(createLabelTextfield("Nuevo Telefono:", telefono));
			box.add(createLabelTextfield("Nuevo Tipo:", tipo));
			
			box.add(Box.createVerticalStrut(20));
			
			enviar=new JButton("Guardar");
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
			else if (e.getSource()==verif) {
				try {
				myhandler.buscarinfoUsuario(this.buscarnombre.getText());
				}
				catch(TPException a) {
					Usuario user = new Usuario();
					user.setNombre(a.getMensaje().split("|")[0]);
					user.setApellido(a.getMensaje().split("|")[1]);
					user.setDireccion(a.getMensaje().split("|")[2]);
					user.setTelefono(a.getMensaje().split("|")[3]);
					user.setTipo(a.getMensaje().split("|")[4]);
					mostrar(user);
				}
			}
			else if (e.getSource()==volver){
				myhandler.ManejoEnviosFrame();
			}
			else if (e.getSource()==enviar){
				String apellido;
				String nombre;
				String telefono;
				String direccion;
				String estado;
				String destino;
				String buscarapellido;
				String buscarnombre;
				String tipo;
				
				//buscarapellido = this.buscardireccion.getText();
				buscarnombre = this.buscarnombre.getText();
				apellido = this.apellido.getText();
				nombre = this.nombre.getText();
				telefono = this.telefono.getText();
				direccion = this.direccion.getText();
				tipo = this.tipo.getText();
				
				Usuario u = new Usuario();
				
				u.setNombre(nombre);
				u.setApellido(apellido);
				u.setTelefono(telefono);
				u.setDireccion(direccion);
				u.setTipo(tipo);			    
			    
		        myhandler.actualizardatosUsuario(u);
			}
		}
		public void mostrar(Usuario p) {
			apellido.setText(p.getApellido());
			nombre.setText(p.getNombre());
			telefono.setText(p.getTelefono());
			direccion.setText(p.getDireccion());
			tipo.setText(p.getTipo());
		}
}