
// Yön tuşları ile kontrol

import java.awt.*;
import java.awt.event.*;

class kanvas03 extends Canvas implements KeyListener
{
	private int x=0,y=0, y2= 0;
	private int loc = (int) (700 * Math.random()) ;
	private boolean press = false ;
	
	public kanvas03()
	{
		setBackground(Color.yellow);
		addKeyListener(this);   
	}
	
	public void paint(Graphics p)
	{
		//uçak
		p.drawRect(x,y,50,30);
		p.setColor(Color.cyan);
		p.fillRect(x, y, 50, 30);
		//zemin
		p.drawRect(0,500,800,500);
		p.setColor(Color.darkGray);
		p.fillRect(0, 500, 800, 500);
		//kutu
		p.drawRect(loc,460,80,40);
		p.setColor(Color.pink);
		p.fillRect(loc, 460, 80, 40);
		//izmir bombası
		p.drawOval(x, y2, 20, 20);
		p.setColor(Color.red);
		p.fillOval(x, y2, 20, 20);		
		if(y2 >= 420 && y2 <= 500 && x <= loc+80 && x >= loc-80) {
			loc = (int) (700 * Math.random());
			x = -60;
			y2  = 0;
			press = false ;
			Font tt = new Font("Times New Roman",Font.PLAIN,40);
			p.drawString("YOU DID IT!", 400, 400);
		}
		if(press == true) {
			y2 = y2 + 10 ;
		}
		x = x + 5 ; 
		
		if(x>800 || y2 >600 ) {
			x = -60;
			y2  = 0;
			press = false ;
			loc = (int) (700 * Math.random());
		try {
			Thread.sleep(70);
			}
		catch(Exception e) {}
		}
		try {
			Thread.sleep(70);
		}
	    catch(Exception e) {}
		
	repaint();
	
	}
	
	public void keyPressed(KeyEvent e)
 	{
 		int tus = e.getKeyCode();
 		if(tus== KeyEvent.VK_SPACE) {
 			 press = true;			 		
 		}
 		repaint();	
 	}	
 		
 	public void keyReleased(KeyEvent e) {}	
 	public void keyTyped(KeyEvent e) {}			   
}

public class klavye01 implements WindowListener
{
	private Frame a;
	private kanvas03 k;

	public klavye01()
	{
		a = new Frame();
		k = new kanvas03();
		a.addWindowListener(this);
		a.add(k);
		a.setSize(800,600);
		a.setResizable(false);
		a.setVisible(true);
	}
	
	public static void main(String args[])
	{
		klavye01 uygulama = new klavye01();
	}

	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) 
	{
		System.exit(0);
	}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}

