package clase1;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pruebapanel1 extends JPanel{
	
	public Pruebapanel1() {
		initUI();
	}

		private void initUI() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			Box nombreBox = Box.createHorizontalBox();
			nombreBox.add(new JLabel("Nombre: "));
			nombreBox.add(new JTextField(30));
		}
}
