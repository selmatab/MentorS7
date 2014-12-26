
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class Paint extends JPanel implements ActionListener {
	int frame = 0;
	Dimension dimension = new Dimension(500, 500);

	DrawCircle circle = new DrawCircle(120, 140, 50, true, Color.BLUE, 2, 2,
			dimension);
	DrawCircle circle2 = new DrawCircle(20, 110, 50, true, Color.RED, 2, 2,
			dimension);
	DrawCircle circle3 = new DrawCircle(20, 20, 60, true, Color.GREEN, 3, 5,
			dimension);

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		circle.checkColision(circle2);
		circle.Draw(g);
		circle2.Draw(g);
		circle3.Draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame++;
		repaint();
	}
}