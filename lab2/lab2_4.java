import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class lab2_4 extends JPanel {
      
	int ans;
	int a, b, c;
	int radius1, radius2;
	int w, h;
	lab2_4Test frame;
	
	lab2_4( int input, lab2_4Test l ) {
		ans = input;
		radius1 = (int)( Math.random() * 150 );
		radius2 = (int)( Math.random() * 150 );
		
		frame = l;
	}  
	  
    public void paintComponent( Graphics g ) { 
        super.paintComponent( g ); 
		
        int width = getWidth(); 
        int height = getHeight();
		w = frame.getWidth();
		h = frame.getHeight();
		
		int x1 = ( width / 2 ) - radius1; 
		int y1 = ( height / 2 ) - radius1;
		int x2 = ( w / 2 ) - radius2; 
		int y2 = ( h / 2 ) - radius2;
      
		if( radius1 > radius2 ) {
			if( ans == 0 ) {
				a = (int)( Math.random() * 256 );
				b = (int)( Math.random() * 256 );
				c = (int)( Math.random() * 256 );
				g.setColor( new Color( a, b, c ) );
				g.fillRect( x1, y1, radius1, radius1 );
				a = (int)( Math.random() * 256 );
				b = (int)( Math.random() * 256 );
				c = (int)( Math.random() * 256 );
				g.setColor( new Color( a, b, c ) );
				g.fillRect( x2, y2, radius2, radius2 );
			}
			else if( ans == 1 ) {
				a = (int)( Math.random() * 256 );
				b = (int)( Math.random() * 256 );
				c = (int)( Math.random() * 256 );
				g.setColor( new Color( a, b, c ) );
				g.fillOval( x1, y1, radius1, radius1 ); 
				
				a = (int)( Math.random() * 256 );
				b = (int)( Math.random() * 256 );
				c = (int)( Math.random() * 256 );
				g.setColor( new Color( a, b, c ) );
				g.fillOval( x2, y2, radius2, radius2 );
			}
		}
		if ( radius2 > radius1 ) {
			if( ans == 0 ) {
				a = (int)( Math.random() * 256 );
				b = (int)( Math.random() * 256 );
				c = (int)( Math.random() * 256 );
				g.setColor( new Color( a, b, c ) );
				g.fillRect( x2, y2, radius1, radius1 );
				a = (int)( Math.random() * 256 );
				b = (int)( Math.random() * 256 );
				c = (int)( Math.random() * 256 );
				g.setColor( new Color( a, b, c ) );
				g.fillRect( x1, y1, radius2, radius2 );
			}
			else if( ans == 1 ) {
				a = (int)( Math.random() * 256 );
				b = (int)( Math.random() * 256 );
				c = (int)( Math.random() * 256 );
				g.setColor( new Color( a, b, c ) );
				g.fillOval( x2, y2, radius1, radius1 ); 
				a = (int)( Math.random() * 256 );
				b = (int)( Math.random() * 256 );
				c = (int)( Math.random() * 256 );
				g.setColor( new Color( a, b, c ) );
				g.fillOval( x1, y1, radius2, radius2 );
			}
		}

	}
}
  
