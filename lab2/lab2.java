import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class lab2 extends JPanel {
	
	private int ans;
	private lab2Test frame;
	private int frameWidth, frameHeight;
	private int radius;
	
	public lab2( int input, lab2Test frame ) {
		ans = input;
		this.frame = frame;
	}
	
	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
		
		frameWidth = frame.getWidth();
		frameHeight = frame.getHeight();
		
		for( int i = 0; i < ans; i++ ) {
			g.setColor( new Color( (int)( Math.random()*256 ), (int)( Math.random()*256 ), (int)( Math.random()*256 ) ) );
			radius = (int)( Math.random() * 50 );
			int x = (int)( Math.random() * ( frameWidth - ( radius * 2) ) );
			int y = ( frameHeight / 2 ) - radius;
			g.fillRect( x, y, radius, radius );
		}
	} 
}
