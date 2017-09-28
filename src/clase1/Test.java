package clase1;
import javax.swing.JApplet;
import javax.swing.JFrame;
public class Test {
	public static void main(String[] args) {
		JFrame frame = new JFrame("texto");
		frame.setSize(300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para matar tanto grafica como el back(sino te cierra la ventana pero sigue corriendo)
		
		frame.getContentPane().add(new Pruebapanel1());
		
		frame.setVisible(true);
	}
}
