import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.DecimalFormat;

public class panel extends JPanel implements MouseListener, MouseMotionListener{
	
	private JButton pointButton;
	private JButton lengthButton;
	private int x, y;
	private int lastX, lastY;
	private boolean count;
	private int status;
	
	panel(){
	
		addMouseListener(this);
		addMouseMotionListener(this);
		
		count = false;
		status = 0;
	}

	//MouseListener
	public void mousePressed(MouseEvent event){
		
		Graphics g = getGraphics();
		Graphics2D g2 = (Graphics2D) g;

		x = event.getX();
		y = event.getY();
		
		//point
		if( x >= 50 && x <=100 && y >= 50 && y <=70 ) {
			status = 1;
			if( count == false ) {
				count = true;
			}
		}
		//length
		else if( x >= 100 && x <=150 && y >= 50 && y <=70 ) {
			status = 2;
			if( count == false ) {
				count = true;
			}
		}
		
		//draw
		else if( count == true && status > 0 ) {
			g2.setStroke(new BasicStroke(4.0f));
			g2.drawLine(x, y, lastX, lastY);
			
			if( status == 1 ) {
			String coordinate = "(" + x + "," + y + ")";
			g2.setColor( Color.BLACK );
			g2.drawString( coordinate, x, y );
			}else if ( status == 2 ) {
				double distance = (x-lastX) * (x-lastX) + (y-lastY) * (y-lastY);
				distance = Math.sqrt(distance);
				DecimalFormat formatter = new DecimalFormat("#.##");
				String s = formatter.format( distance );
				s = "(" + s + ")";
				g2.setColor( Color.RED );
				g2.drawString( s, (x+lastX)/2, (y+lastY)/2 );
			}
			lastX = x;
			lastY = y;
		}
		else {
			lastX = x;
			lastY = y;
			
			g2.setStroke(new BasicStroke(4.0f));
			g2.drawLine(x, y, lastX, lastY);
		}
	}
	public void mouseReleased(MouseEvent event){}
    public void mouseClicked(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}
    public void mouseExited(MouseEvent event){}
	
	//MouseMotionListener
	public void mouseDragged( MouseEvent event ){}
    public void mouseMoved( MouseEvent event ){}

    public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawRect( 50, 50, 50, 20 );
		g.drawString( "point", 55, 65 );
		g.drawRect( 100, 50, 50, 20 );
		g.drawString( "length", 105, 65 );
    }

}