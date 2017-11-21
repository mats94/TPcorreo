package interfaces;

import javax.swing.JFrame;

class Ventana extends JFrame{
	// ventana generica 
	Ventana(Handler handler){
		this.setSize(300,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
