import java.awt.*;
import javax.swing.JApplet;

public class HW2_2 extends JApplet {
	
	public void paint( Graphics g ) {
		super.paint( g );

		setBackground( Color.WHITE );

		//roof
		g.setColor( Color.CYAN );
		int xpoints[] = {30, 200, 370};
		int ypoints[] = {180, 40, 180};
		int npoints = 3;
		g.fillPolygon( xpoints, ypoints, npoints );

		//body
		g.setColor( Color.MAGENTA );
		g.fillRect( 80, 180, 225, 150 );
		
		//windows
		g.setColor( Color.WHITE );
		g.fillOval( 100, 200, 50, 50 );
		g.fillOval( 230, 200, 50, 50 );

		//door
		g.setColor( Color.RED );
		g.fillRect( 180, 280, 40, 50 );
		
	}

}