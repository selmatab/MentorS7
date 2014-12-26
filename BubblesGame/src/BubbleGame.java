import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BubbleGame {
	private static final int START_NUMBER = 4;
	static int frame = 0;
	public static Bubbles bubbles;
	public static int getIndex;
	static int point = 0;
	static JLabel points = new JLabel();

	public static void main(String[] args) {
		bubbles = new Bubbles(START_NUMBER);
		DisappearListener disappear = new DisappearListener();
		JFrame window = new JFrame("Pop the Bubble");
		window.setSize(600, 400);
		window.setLocation(400, 200);
		window.setResizable(false);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		// kreiram panel
		NasPanel mojPanel = new NasPanel();
		mojPanel.addMouseListener(disappear);
		mojPanel.setBackground(Color.YELLOW);
		mojPanel.add(points);
		// dodajem panel na frame
		window.add(mojPanel);
		window.setVisible(true);
		Timer frameTimer = new Timer(10, mojPanel);
		frameTimer.start();

	}

	public static class NasPanel extends JPanel implements ActionListener {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawFrame(g, frame++);
		}

		// crtanje
		private void drawFrame(Graphics g, int frame) {
			for (int i = 0; i < bubbles.getBubbles().length; i++) {
				bubbles.getBubbles()[i].move(frame);
				bubbles.getBubbles()[i].draw(g, frame);
				//primitivno odbijanje
				bubbles.checkCollision();
			}
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}

	}

	// ispituje da li je kliknut krug ili ne
	public static class DisappearListener implements MouseListener {

		@Override
		public void mousePressed(MouseEvent e) {
			if (inRange(e.getX(), e.getY())) {
				bubbles.addBubble(bubbles.getBubbles(), getIndex);
				point++;
				points.setText(String.valueOf(point)); // povecava broj poena
			}
			// prosiruje niz
			else
				bubbles.expandBubble();

		}

		// da li je klik u okviru kruga
		private boolean inRange(int x, int y) {
			for (int i = 0; i < bubbles.getBubbles().length; i++) {
				if ((x > bubbles.getBubbles()[i].getPositionX())
						&& (x < bubbles.getBubbles()[i].getPositionX() + 20)
						&& (y > bubbles.getBubbles()[i].getPositionY())
						&& (y < bubbles.getBubbles()[i].getPositionY() + 20)) {
					getIndex = i;
					return true;
				}
			}
			return false;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}