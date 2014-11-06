
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;

public class P_4 extends JPanel implements KeyListener {
	
    private int sleepTime;
	private int x,y,index;
    private Timer time;
    private int speed;

	public P_4()
	{
	   x = 500; y = 300;
	   sleepTime = 50;
	   start();

	   addKeyListener( this );
	   speed = 10;
	}
	
		public void start()
	{
	  	   time = new Timer();
	       time.schedule( new TimerTask() {
						public void run()
						{
						   //----------------------------------------
						   
						    if(x < getWidth()) {
						      	x += speed;
						    }
						    else {
						        x = 0;
						    }
						    repaint();
						   //---------------------------------------
						}
						
					},0,sleepTime); 
	 
	}
	
    public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawRect(x, y, 40, 40);
    }

    public void keyTyped(KeyEvent e) {
        
    }
    public void keyPressed(KeyEvent e) {
        if( e.getKeyCode() == KeyEvent.VK_UP ) {
        	if( y < 0 )
        		y = getHeight();
        	else 
        		y -= speed;
        }
        if( e.getKeyCode() == KeyEvent.VK_DOWN ) {
        	if( y > getHeight() )
        		y = 0;
        	else
        		y += speed;
        }
        if( e.getKeyCode() == KeyEvent.VK_RIGHT ) {
        	if( x > getWidth() ) {
        		x = 0;
        	}
        	else
        		x += speed;
        }
        if( e.getKeyCode() == KeyEvent.VK_LEFT ) {
        	if( x < 0 ) {
        		x = getWidth();
        	}
        	else
        		x -= speed;
        }
        repaint();
    }
    public void keyReleased(KeyEvent e) {
        
    }
	
}