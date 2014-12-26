// Imamo dva text polja od kojih jedno sluzi za unos broja, a drugo za ispis svih parnih brojeva do tog broja.
//Takodjer trebamo imati button koji potvrdjuje unos.

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI_102 {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(300, 400);
		frame.setTitle("GUI_102");

		JPanel panel = new JPanel();
		panel.setSize(250, 250);
		final JTextField textfield = new JTextField(10);
		panel.add(textfield, BorderLayout.CENTER);
		JButton buton = new JButton("OK");

		panel.add(buton, BorderLayout.EAST);
		final JTextArea field = new JTextArea();
		field.setLineWrap(true);
		panel.add(field, BorderLayout.SOUTH);

		textfield.addActionListener(new ActionListener() {

			// ono sto je uneseno u textField pretvaramo u integer i ispitujemo
			// parne brojeve od 2 do tog broja, te rezultat upisujemo u textArea
			// field.
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(textfield.getText());
				String myString = "";
				for (int i = 2; i <= num; i++) {
					if (i % 2 == 0)
						myString += i + ",";
				}
				field.setText(myString);

			}
		});

		frame.add(panel);
		frame.setVisible(true);
	}
}
