package interfaces;
import java.awt.Color;
import interfaces.*;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class Test {
	public static void main(String[] args) {
		
		
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
		
		
		JFrame frame4 = new JFrame("Correo");
		frame4.setJMenuBar(menubar);
		frame4.setTitle("Login");
		
		frame4.setSize(300, 500);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.getContentPane().add(new Login());
		frame4.setVisible(true);
		
	}
}
