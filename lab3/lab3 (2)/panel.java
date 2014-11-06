import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class panel extends JPanel implements MouseListener, MouseMotionListener{
	
	private JButton[] button = new JButton[ 4 ];
	private Color drawColor;
	private boolean clear;
	int lastX, lastY;
	
	panel(){
		addMouseListener(this);
		addMouseMotionListener(this);
			
		setButton();
	}
	
	private void setButton() {
		Color[] color = { Color.BLACK, Color.RED, Color.BLUE, Color.WHITE };
		
		ButtonHandler handler = new ButtonHandler();
	
		for( int i = 0; i < button.length; i++ ) {
			button[ i ] = new JButton();
			button[ i ].setBackground( color[ i ] );
			button[ i ].setPreferredSize( new Dimension( 40, 40 ) );
			add( button[ i ] );
			button[ i ].addActionListener( handler );
		}
	}
	
	private class ButtonHandler implements ActionListener {
		
		public void actionPerformed( ActionEvent event ) {
			if( event.getSource() == button[ 0 ] ) {
				clear = false;
				drawColor = Color.BLACK;
			}
			else if ( event.getSource() == button[ 1 ] ) {
				clear = false;
				drawColor = Color.RED;
			}
			else if ( event.getSource() == button[ 2 ] ) {
				clear = false;
				drawColor = Color.BLUE;
			}
			else if ( event.getSource() == button[ 3 ] ) {
				clear = true;
			}
		}
	}
	
	//MouseListener
	public void mousePressed(MouseEvent event){
		
		Graphics g = getGraphics();
		Graphics2D g2 = (Graphics2D) g;

		int x = event.getX();
		int y = event.getY();
		lastX = x;
		lastY = y;
	}
	
	public void mouseReleased(MouseEvent event){}
    public void mouseClicked(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}
    public void mouseExited(MouseEvent event){}
	
	//MouseMotionListener
	public void mouseDragged( MouseEvent event ){
		Graphics g = getGraphics();
		Graphics2D g2 = (Graphics2D) g;

		int x = event.getX();
		int y = event.getY();
		
		g2.setColor( drawColor );
		
		if( clear == true ) {
			g2.clearRect( x, y, 4, 4 );
		}
		else {
			g2.setStroke( new BasicStroke( 4.0f ) );
			g2.drawLine( lastX, lastY, x, y );
		}
		lastX = x;
		lastY = y;
	}
    public void mouseMoved( MouseEvent event ){}

    public void paintComponent(Graphics g){
		super.paintComponent(g);
    }
}