import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Ball extends JComponent  {

	private int dy = 0;
	private int dx = 0;
	
	public Ball(int x, int y)
	{
		setLocation(x,y);
		setSize(30,40);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ball = new Ellipse2D.Double(20, 0, 5, 5);
		g2.fill(ball);
		
	
	}
	public void setDY(int y)
	{
		dy = y;
	}
	public void setDX(int x)
	{
		dx = x;
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
		
	}
}
