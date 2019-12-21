package interfaces;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import entidades.Pedido;
import entidades.Usuario;
import interfaces.Login;
import utils.TPException;

public class Handler {
	private Login jframe;
	private PedidoBO bo;
	public Handler() {
		loginframe();
		try {
		bo = new PedidoBO(this);
		} catch (TPException e) {
			mostrarmsj("test");
		}
	}
	
	private void loginframe() {
	jframe = new Login(this);
	jframe.setSize(300,500);
	jframe.setVisible(true);
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public void ManejoEnviosFrame() {
		//JFrame frame = new JFrame("Correo");
		jframe.setTitle("Menu Principal");
		//jframe.setJMenuBar(menu());
		jframe.cambio(new Principal(this));
	}
	
	public void AdministradorFrame() {
		//JFrame frame = new JFrame("Correo");
		jframe.setTitle("Menu Principal");
		jframe.setJMenuBar(menu());
		jframe.cambio(new Administrador(this));
	}
	
	public void baja() {
		jframe.setTitle("Eliminar Pedido");
		jframe.cambio(new Baja(this));
	}
	
	public void modificacion() {
		jframe.setTitle("Modificar Pedido");
		jframe.cambio(new Modificacion(this));
	}
	
	public void alta() {
		jframe.setTitle("Nuevo Pedido");
		jframe.cambio(new Alta(this));
	}
	
	//Usuarios ABM
	public void UsuarioBaja() {
		jframe.setTitle("Eliminar Usuario");
		jframe.cambio(new Baja(this));
	}
	
	public void UsuarioModificacion() {
		jframe.setTitle("Modificar Usuario");
		jframe.cambio(new ModificarUsuario(this));
	}
	
	public void UsuarioAlta() {
		jframe.setTitle("Nuevo Usuario");
		jframe.cambio(new AltaUsuario(this));
	}
	//Fin usuarios ABM
	
	
	public void mostrarERROR(String msj) {
		jframe.mostrarERROR(msj);
	}
	public void mostrarmsj(String msj) {
		jframe.mostrarmsj(msj);
	}
	public void mandardatos(Pedido u) {
		try {bo.crearPedido(u);}catch(TPException e){mostrarmsj(e.getMensaje());}
	}
	public void guardarUsuario(Usuario u) {
		try {bo.crearUsuario(u);}catch(TPException e){mostrarmsj(e.getMensaje());}
	}
	public void actualizardatos(Pedido u) {
		try{
		bo.actualizaPedido(u);
		} catch (TPException e) {
			mostrarmsj(e.getMensaje());
		}catch (SQLException e) {
			mostrarERROR(e.getMessage());
		}
	}
	
	public void actualizardatosUsuario(Usuario u) {
		try{
		bo.actualizaUsuario(u);
		} catch (TPException e) {
			mostrarmsj(e.getMensaje());
		} catch (SQLException e) {
			mostrarERROR(e.getMessage());
		}
	}
	
	public void buscarinfo(String dato) throws TPException{
		try {
		bo.buscarinfo(dato);
		}catch(TPException e) {
			throw e;
		}
	}
	
	public void buscarinfoUsuario(String dato) throws TPException{
		try{
			bo.buscarinfoUsuario(dato);
		}
		catch(TPException e) {
			mostrarmsj(e.getMensaje());
			throw e;
		}catch (SQLException e) {
			mostrarERROR(e.getMessage());
		}
	}
	public void mostrarMOD(Pedido p) {
			
	}
	public void eliminar(String dato) {
		try{
			bo.borraPedido(dato);
		} catch (TPException e) {
			mostrarmsj(e.getMensaje());
		}catch (SQLException e) {
			mostrarERROR(e.getMessage());
		}
	}
	public void authUser(String usuario, String password) throws TPException{
		try {
			bo.authUser(usuario, password);
		}catch(TPException e) {
			throw e;
		}catch (SQLException e) {
			mostrarERROR(e.getMessage());
		}
	}
	
	public JMenuBar menu() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		//JMenuItem submenuCrear = new JMenuItem("Crear Empleado");
		JMenuItem submenuCrear = new JMenuItem(new AbstractAction("Crear Empleado") {
		    public void actionPerformed(ActionEvent c) {
		    	UsuarioAlta();
		    }
		});
		JMenuItem submenuModifica = new JMenuItem(new AbstractAction("Modificar Empleado") {
		    public void actionPerformed(ActionEvent m) {
		    	UsuarioModificacion();
		    }
		});
		JMenuItem submenuEliminar = new JMenuItem(new AbstractAction("Eliminar Empleado") {
		    public void actionPerformed(ActionEvent e) {
		    	UsuarioBaja();
		    }
		});
		

		menu.add(submenuCrear);menu.add(submenuModifica);menu.add(submenuEliminar);
		menubar.add(menu);
		
		return menubar;
	}

}
