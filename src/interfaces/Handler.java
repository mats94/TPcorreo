package interfaces;
import java.awt.BorderLayout;

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
	
	public void principalframe() {
		//JFrame frame = new JFrame("Correo");
		jframe.setTitle("Menu Principal");
		jframe.setJMenuBar(menu());
		jframe.cambio(new Principal(this));
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
	public void mostrarERROR(String msj) {
		jframe.mostrarERROR(msj);
	}
	public void mostrarmsj(String msj) {
		jframe.mostrarmsj(msj);
	}
	public void mandardatos(Pedido u) {
		bo.crearPedido(u);
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
		JMenu submenu = new JMenu("Menu Principal");
		JMenuItem submenu2 = new JMenuItem("Crear Empleado");
		JMenuItem submenu3 = new JMenuItem("Modificar Empleado");
		JMenuItem submenu4 = new JMenuItem("Eliminar Empleado");
		JMenuItem menuitem = new JMenuItem("menu item 1");
		
		submenu.add(menuitem);
		submenu.add(submenu2);
		submenu.add(submenu3);
		submenu.add(submenu4);
		
		menu.add(submenu);
		menubar.add(menu);
		
		return menubar;
	}

}
