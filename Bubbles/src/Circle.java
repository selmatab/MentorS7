// Zadatak: Napraviti animaciju koja sadrzi nekoliko baloncica koji se krecu i koji se prilikom medjusobnog dodira odbijaju.
//Kada dodju do zidova prozora moraju promjeniti smjer.
//Ako kliknemo dodaje se novi prozor, a ako kliknemo na baloncic on nestaje.
	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.Timer;

	public class Circle extends JPanel implements ActionListener {
		int frame = 0;

		public static void main(String[] args) {

			Paint circle = new Paint();
			JFrame window = new JFrame();
			window.setContentPane(circle);
			circle.repaint();
			window.setSize(500, 500);
			window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
			window.setVisible(true);
			Timer timer = new Timer(10, circle);
			timer.start();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			frame++;
			repaint();
		}
}
