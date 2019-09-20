 

import java.awt.*;

public class Text extends Shape
{
	private static final long serialVersionUID = 1L;

	public void draw(Graphics2D g) {
		//Font(String name, int style, int size) 
		g.setColor(color);
		g.setFont(new Font(fontName, italic+blodtype, fontSize));
		if (s != null) {
			g.drawString(s, x1, y1);
			//System.out.println(fontName+"  "+s+" "+fontSize );
		}
	}
}