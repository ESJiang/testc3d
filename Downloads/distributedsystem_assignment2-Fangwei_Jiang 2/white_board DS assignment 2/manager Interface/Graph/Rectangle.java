import java.awt.*;

public class Rectangle extends Shape {
	private static final long serialVersionUID = 1L;
	public Rectangle(){
		
		
	}
	public void draw(Graphics2D g2d) {
		
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(width));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
			Math.abs(y1 - y2));
	}
}