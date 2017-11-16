package interfaces;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfaces.Login;
public class Handler {
	public Handler() {
		loginframe();
	}
	
	private void loginframe() {
	Login frame = new Login();
	frame.setSize(300,500);
	frame.setVisible(true);
	}
	public static void principal() {
		principal2();
	}
	private static void principal2() {
		JFrame frame = new JFrame("Correo");
		frame.setJMenuBar(menu());
		frame.setTitle("Menu Principal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.getContentPane().add(new Principal());
		frame.setSize(300, 500);
		frame.setVisible(true);
	}
	public static void modificacion() {
		modificacion2();
	}
	private static void modificacion2() {
		JFrame frame = new JFrame("Correo");
		frame.setTitle("Modificar");
		frame.setSize(300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Modificacion());
		frame.setVisible(true);
	}
	
	private static JMenuBar menu() {
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
