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
		JFrame frame = new JFrame("Correo");
		frame.setTitle("TP CORREO");
		
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenu submenu = new JMenu("submenu");
		JMenuItem menuitem = new JMenuItem("menu item 1");
		submenu.add(menuitem);
		menu.add(submenu);
		menubar.add(menu);
		frame.setJMenuBar(menubar);
		
		//frame.setJMenuBar(createMenu());
		frame.setSize(300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para matar tanto grafica como el back(sino te cierra la ventana pero sigue corriendo)
		frame.getContentPane().add(new Alta());
		frame.setVisible(true);
		
		JFrame frame1 = new JFrame("Correo");
		frame1.setJMenuBar(menubar);
		frame1.setTitle("Baja");
		
		frame1.setSize(300, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().add(new Baja());
		frame1.setVisible(true);
		
		JFrame frame2 = new JFrame("Correo");
		frame2.setJMenuBar(menubar);
		frame2.setTitle("Modificacion");
		
		frame2.setSize(300, 500);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().add(new Modificacion());
		frame2.setVisible(true);
		
	}
}
