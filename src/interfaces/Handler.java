package interfaces;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import entidades.Pedido;
import interfaces.Login;
public class Handler {
	private Login jframe;
	private PedidoBO bo;
	public Handler() {
		loginframe();
		bo = new PedidoBO(this);
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
		jframe.add(menu());
		jframe.cambio(new Principal(this));
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
		bo.actualizaPedido(u);
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
	
	public JMenuBar menu() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenu submenu = new JMenu("Menu Principal");
		JMenu submenu2 = new JMenu("Crear Empleado");
		JMenu submenu3 = new JMenu("Modificar Empleado");
		JMenu submenu4 = new JMenu("Eliminar Empleado");
		JMenuItem menuitem = new JMenuItem("menu item 1");
		submenu.add(menuitem);
		menu.add(submenu);
		menu.add(submenu2);
		menu.add(submenu3);
		menu.add(submenu4);
		menubar.add(menu);
		return menubar;
	}

}
