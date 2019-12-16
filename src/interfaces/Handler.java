package interfaces;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import entidades.Pedido;
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
		jframe.setJMenuBar(menu());
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

	//TODO falta panel mostrar todos
	
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
		jframe.cambio(new Modificacion(this));
	}
	
	public void UsuarioAlta() {
		jframe.setTitle("Nuevo Usuario");
		jframe.cambio(new Alta(this));
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
	public void actualizardatos(Pedido u) {
		//try{
		bo.actualizaPedido(u);
		//} catch (DAOException) {
		// JOPtionPane mostrar error
		//}
	}
	public void buscarinfo(String dato,Modificacion m) {
		bo.buscarinfo(dato,m);
	}
	public void mostrarMOD(Pedido p, Modificacion m){
		m.mostrar(p);
	}
	public void eliminar(String dato) {
		bo.borraPedido(dato);
	}
	
	//TODO sacar el panel botones y usar la menubar
	public JMenuBar menu() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		//JMenuItem submenuCrear = new JMenuItem("Crear Empleado");
		JMenuItem submenuCrear = new JMenuItem(new AbstractAction("Crear Empleado") {
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("holaaa");
		    }
		});
		JMenuItem submenuModifica = new JMenuItem("Modificar Empleado");
		JMenuItem submenuEliminar = new JMenuItem("Eliminar Empleado");
		

		menu.add(submenuCrear);menu.add(submenuModifica);menu.add(submenuEliminar);
		menubar.add(menu);
		
		return menubar;
	}

}
