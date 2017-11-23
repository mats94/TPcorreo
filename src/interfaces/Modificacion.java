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
import javax.swing.JTextField;

import entidades.Pedido;

public class Modificacion extends JPanel implements ActionListener{
	private JButton salir;
	private JButton volver;
	private JButton enviar;
	private JButton verif;
	private Handler myhandler;
	private JTextField buscarapellido;
	private JTextField buscarnombre;
	private JTextField apellido;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField direccion;
	private JTextField estado;
	private JTextField destino;
	public Modificacion(Handler handler) {
	
			myhandler = handler;
			
			Box box = Box.createVerticalBox();
			buscarnombre = new JTextField(10);
			buscarapellido = new JTextField(10);
			nombre = new JTextField(10);
			apellido = new JTextField(10);
			telefono = new JTextField(10);
			direccion = new JTextField(10);
			estado = new JTextField(10);
			destino = new JTextField(10);
			
			box.add(createLabelTextfield("Nombre del cliente:", buscarnombre));
			box.add(createLabelTextfield("Apelldio del cliente:", buscarapellido));
			
			box.add(Box.createVerticalStrut(10));
			
			verif=new JButton("Verificar");
			verif.setBounds(300,250,100,30);
		 	box.add(verif);
		 	verif.addActionListener(this);
		 	
		 	box.add(Box.createVerticalStrut(10));
		 	
			box.add(createLabelTextfield("Nuevo Nombre:", nombre));
			box.add(createLabelTextfield("Nuevo Apellido:", apellido));
			box.add(createLabelTextfield("Nueva Direccion:", telefono));
			box.add(createLabelTextfield("Nuevo Telefono:", direccion));
			box.add(createLabelTextfield("Nuevo Destino:", estado));
			box.add(createLabelTextfield("Nuevo Estado del envio:", destino));
			
			box.add(Box.createVerticalStrut(20));
			
			enviar=new JButton("Enviar formulario");
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
				String buscarapellido;
				String buscarnombre;
				
				buscarapellido = this.buscarapellido.getText();
				buscarnombre = this.buscarnombre.getText();
				apellido = this.apellido.getText();
				nombre = this.nombre.getText();
				telefono = this.telefono.getText();
				direccion = this.direccion.getText();
				estado = this.estado.getText();
				destino = this.destino.getText();
				
				Pedido u = new Pedido();
				
				u.setBuscarnombre(buscarnombre);
				u.setBuscarapellido(buscarapellido);
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