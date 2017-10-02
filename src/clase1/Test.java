package clase1;
import java.awt.Color;
import java.awt.FlowLayout;

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
		JFrame frame = new JFrame("Correo");
		frame.setTitle("TP CORREO");
		//menu bar
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenu submenu = new JMenu("submenu");
		JMenuItem menuitem = new JMenuItem("menu item 1");
		submenu.add(menuitem);
		menu.add(submenu);
		menubar.add(menu);
		
		//fin menu bar
		frame.setJMenuBar(menubar);
		frame.setSize(300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para matar tanto grafica como el back(sino te cierra la ventana pero sigue corriendo)
		//frame.setBackground(new JLabel(new ImageIcon("/Users/matiasbarros/Downloads/correo2.jpg")));
		frame.getContentPane().add(new Pruebapanel1());
		
		
		frame.setVisible(true);
	}
}
