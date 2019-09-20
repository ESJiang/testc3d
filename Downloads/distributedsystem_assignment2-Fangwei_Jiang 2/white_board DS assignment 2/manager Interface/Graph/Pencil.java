import java.awt.*;

public class Pencil extends Shape {
	private static final long serialVersionUID = 1L;
	public Pencil(){
		
	}
	public void draw(Graphics2D g) {
		g.setPaint(color);
		//Ϊ Graphics2D ���������� Stroke
		g.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		//Ϊ�����㷨���õ�����ѡ���ֵ��
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawLine(x1, y1, x2, y2);
	}
}


