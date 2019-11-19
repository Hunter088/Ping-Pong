package pingpong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pong extends JPanel implements KeyListener,ActionListener {
	
	private boolean play = false;
	private int p1X = 260, p2X = 260;
	private int scr1 = 0, scr2 = 0;
	private int ballX = 100, ballY = 300;
	private int balldirX = -1, balldirY = -2;
	
	private Timer timer;
	private int delay = 8;
	
	public Pong() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		//background
		g.setColor(new Color(65, 105, 225));
		g.fillRect(0, 0, 592, 570);
		
		//border
		g.setColor(Color.RED);
		g.fillRect(0, 0, 4, 570);
		g.fillRect(590, 0, 4, 570);
		
		//paddle
		g.setColor(Color.CYAN);
		g.fillRect(p1X, 548, 120, 20);
		g.setColor(Color.MAGENTA);
		g.fillRect(p2X, 3, 120, 20);
		
		//ball 
		g.setColor(Color.GREEN);
		g.fillOval(ballX, ballY, 25, 25);
		
		//score
		g.setColor(Color.WHITE);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString(""+scr1, 50, 400);
		g.drawString(""+scr2, 50, 100);
		
		if (scr1 == 5) {
			play = false;
			balldirX =0;
			balldirY = 0;
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Raleway",Font.BOLD,20));
			g.drawString("Hunter Won Score:"+scr1, 180, 250);
			
			g.drawString("Press Enter to restart", 180, 280);
		}else if(scr2 == 5) {
			play = false;
			balldirX =0;
			balldirY = 0;
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Raleway",Font.BOLD,20));
			g.drawString("Ankit Won Score:"+scr1, 150, 300);
			
			g.drawString("Press Enter to restart", 150, 330);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			
			if(new Rectangle(p1X, 548, 120, 20).intersects(new Rectangle(ballX, ballY, 25, 25))) {
				balldirY = - balldirY;
			}
			
			if(new Rectangle(p2X, 3, 120, 20).intersects(new Rectangle(ballX, ballY, 25, 25))) {
				balldirY = - balldirY;
			}
			ballX+=balldirX;
			ballY+=balldirY;
			
		if(ballX <= 0) {
			balldirX= - balldirX;
		}
		if(ballX >= 570) {
			balldirX = -balldirX;
		}
		
		if(ballY < -30) {
			play = false;
			balldirX = 0;
			balldirY = 0;
			scr1+=1;
			restart();
			
		}
		if(ballY >=570) {
			play = false;
			balldirX = 0;
			balldirY = 0;
			scr2+=1;
			restart();
		}
		
		}
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(p1X > 450) {
				p1X = 470;
			}else
			{
				play = true;
				p1X+=20;
			}
			}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(p1X < 10) {
				p1X = 10;
			}else
			{
				play = true;
				p1X-=20;
			}
			}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			if(p2X > 450) {
				p2X = 470;
			}else
			{
				play = true;
				p2X+=20;
			}
			}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			if(p2X < 10) {
				p2X = 10;
			}else
			{
				play = true;
				p2X-=20;
			}
			}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			scr1 = 0;
			scr2 = 0;
			restart();
			
		}
	
	}
	
	public void restart() {
		
		
		p1X = 260;
		p2X = 260;
		ballX = 100;
		ballY = 300;
		balldirX = -1;
		balldirY = -2;
		
		repaint();
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
