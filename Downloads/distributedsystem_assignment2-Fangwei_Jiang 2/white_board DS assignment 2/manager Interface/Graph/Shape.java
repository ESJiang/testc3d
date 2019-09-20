import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.swing.JPanel;

public abstract class Shape implements Serializable 
{
	private static final long serialVersionUID = 1L;
    int x1, y1, x2, y2, italic, blodtype, width, currentChoice, length, fontSize;
    Color color;
    BufferedImage image; 
    JPanel board; 
    String fontName, s;
    public abstract void draw(Graphics2D g);
}