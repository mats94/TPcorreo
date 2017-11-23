package interfaces;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaces.Login;
public class Handler {
	private Login jframe;
	public Handler() {
		PedidoBO bo = new PedidoBO(this);
		loginframe();
	}
	
	private void loginframe() {
	jframe = new Login(this);
	jframe.setSize(300,500);
	jframe.setVisible(true);
	}
	
	public void principalframe() {
		//JFrame frame = new JFrame("Correo");
		jframe.setTitle("Menu Principal");
		jframe.cambio(new Principal(this));
		
		
		
	}
	public void baja() {
		jframe.setTitle("Baja");
		jframe.cambio(new Baja(this));
	}

	public void modificacion() {
		jframe.setTitle("Modificacion");
		jframe.cambio(new Modificacion(this));
	}
	
	public void alta() {
		jframe.setTitle("Alta");
		jframe.cambio(new Alta(this));
	}
	public void mostrarmsj(String msj) {
		jframe.mostrarmsj(msj);
	}
	
	/*private static JMenuBar menu() {
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
	}*/

}
