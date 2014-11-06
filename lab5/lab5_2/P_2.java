import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;

public class P_2 extends JPanel implements KeyListener {
	
    private int sleepTime;
	private int x,y,index;
    private Timer time;
	private Image image;
	private String imageName;
	private String path;
	private int speed;

	public P_2() {
	   x = 500; y = 300;
	   sleepTime = 50;
	   addKeyListener(this);
	   index = 0;
	   loadImage(index);

	   start();
	   speed = 10;

	   this.setFocusable(true);
       this.requestFocusInWindow();
	}
	
	public void start() {
	  	time = new Timer();
	    time.schedule( new TimerTask() {
			public void run() {
				//System.out.printf("x: %d\n", x);
				if( x < getWidth() ) {
					x += speed;
				}
				else{
					x = 0;
				}
				repaint();
			}

		},0,sleepTime);
	}
	
    public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.drawImage( image, x, y, this );
    }

    public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(index == 2) {
				index = 0;
			}
			else{
				index++;
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(index == 0) {
				index = 2;
			}
			else{
				index--;
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			if( y < 0 ) {
				y = getHeight();
			}
			else{
				y -= speed;
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if( y > getHeight() ) {
				y = 0;
			}
			else{
				y += speed;
			}
		}
		loadImage(index);
		repaint();
		//System.out.printf("index: %d\n", index);
	}

	public void keyReleased(KeyEvent e) {}

	public void loadImage( int i ) {
		path = "images/" + index + ".jpg";
		image = new ImageIcon(path).getImage();
	}
}