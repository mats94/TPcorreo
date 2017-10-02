package clase1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pruebapanel1 extends JPanel{
	
	public Pruebapanel1() {
		initUI();
	}

		private void initUI() {
			// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			createLabelTextfield("Nombre :", 20);
			createLabelTextfield("Apellido :", 20);
			createLabelTextfield("Profesion :", 20);
		}
		private void createLabelTextfield(String campo,int capacidad) {
			
			Box box = Box.createVerticalBox();
			box.add(Box.createVerticalStrut(30));
			box.add(new JLabel(campo));
			box.add(Box.createVerticalStrut(10));
			box.add(wrapTextfield(new JTextField(capacidad)));
			box.add(Box.createVerticalStrut(10));
			setBackground(new Color(0, 200, 0));
			this.add(box);
		}
		private Component wrapTextfield(JTextField textField) {
			JPanel aux = new JPanel();
			aux.add(textField);
			return aux;
		}
}
