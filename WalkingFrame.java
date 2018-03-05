import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private Ball ball;
	ArrayList <Ball> balls = new ArrayList<Ball>();
	public WalkingFrame()
	{
		setBounds(100, 100, 600, 400);
		setLayout(null);
		man = new Man(0,0);
		ball = new Ball(0,10);
		balls.add(ball);
		
		add(man);
		Timer timer = new Timer(10, this); //how often triggers, second parameter is action listener
		timer.start();
		addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent e) 
					{
						if(e.getKeyCode() ==e.VK_W)
						{
							man.setDY(-2);
						}
						if(e.getKeyCode() ==e.VK_S)
						{
							man.setDY(2);
						}
						if(e.getKeyCode() ==e.VK_A)
						{
							man.setDX(-2);
						}
						if(e.getKeyCode() ==e.VK_D)
						{
							man.setDX(2);
						}
						
					}

					@Override
					public void keyReleased(KeyEvent e) 
					{
						if(e.getKeyCode() ==e.VK_W)
						{
							man.setDY(0);
							
						}
						if(e.getKeyCode() ==e.VK_S)
						{
							man.setDY(0);
						}
						if(e.getKeyCode() ==e.VK_A)
						{
							man.setDX(0);
						}
						if(e.getKeyCode() ==e.VK_D)
						{
							man.setDX((0));
						}	
						
						
					}
					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				}
				);
		this.addKeyListener(new KeyListener()
				{
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode() ==e.VK_B)
						{
							Ball ball1 = new Ball(man.getX(),man.getY()+10);
							balls.add(ball1);
							add(ball1);
							ball1.setLocation(man.getX(), man.getY());
							ball1.setDX(10);	
							
						}	
					}
					@Override
					public void keyReleased(KeyEvent e) {
						if(e.getKeyCode() ==e.VK_B)
						{
							
							
						}
					}
					@Override
					public void keyTyped(KeyEvent arg0)
					{
					}
				}
				);
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new WalkingFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		for( Ball a : balls)
		{
			a.update();

			
		}
		for(int i = 0; i < balls.size(); i++)
		{
			if(balls.get(i).getX() > getWidth())
			{
				remove(balls.get(i));
			}
		}
		
		
		man.update();
		repaint(); //calls the paint component method draws and repaint redraws
		
		
	}
	
}
