


	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Graphics;


	public class DrawCircle {

		private int x;
		private int y;
		private int radius;
		private boolean isFilled;
		private Color color;
		private int speedX;
		private int speedY;
		private Dimension windowDimension;
		private int centerX;
		private int centerY;
		private int halfRadius;

		/**
		 *  Circle constructor.
		 * @param x position.
		 * @param y position.
		 * @param radius circle.
		 * @param isFilled with color, or not.
		 * @param color 
		 * @param speedX
		 * @param speedY
		 * @param windowDimension 
		 */
		public DrawCircle(int x, int y, int radius, boolean isFilled, Color color,
				int speedX, int speedY, Dimension windowDimension) {
			this.x = x;
			this.y = y;
			this.radius = radius;
			this.isFilled = isFilled;
			this.color = color;
			this.speedX = speedX;
			this.speedY = speedY;
			this.windowDimension = windowDimension;
			this.centerX = x + radius / 2;
			this.centerY = y + radius / 2;
			this.halfRadius = radius / 2;
		}

		// Draw method.
		public void Draw(Graphics g) {
			move();
			g.setColor(color);
			if (isFilled == true) {
				g.fillOval(x, y, radius, radius);
			} else {
				g.drawOval(x, y, radius, radius);
			}
		}

		//  Move method - if circle touches the edges - change direction.
		private void move() {
			if (x < 0 || x + radius >= windowDimension.getWidth()) {
				speedX *= -1;
			}
			if (y < 0 || y + radius + radius / 2 > windowDimension.getHeight()) {
				speedY *= -1;
			}
		
			centerX = centerX + speedX;
			centerY = centerY + speedY;
			x = x + speedX;
			y = y + speedY;
		}

		// Checking Collision of two circle (then change direction of one)
		public void checkColision(DrawCircle other) {

			double iks = this.centerX - other.centerX;
			double ipsilon = this.centerY - other.centerY;
			double distance = Math.sqrt(iks * iks + ipsilon * ipsilon);

			if (distance <= halfRadius + other.halfRadius){
				speedX*=-1;
			    other.speedX*=-1;
			}
			
		}
	}

