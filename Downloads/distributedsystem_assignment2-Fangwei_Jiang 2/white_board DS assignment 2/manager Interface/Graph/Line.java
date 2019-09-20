import java.awt.*;


public class Line extends Shape {
	private static final long serialVersionUID = 1L;

	public Line() {
		
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.setStroke(new BasicStroke(width));
		g.drawLine(x1, y1, x2, y2);
	}

}
