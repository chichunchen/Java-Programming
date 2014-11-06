
import classData.ch08.MyLine;
import classData.ch08.MyRectangle;
import classData.ch08.MyOval;
import javax.swing.JApplet;
import java.util.*;
import java.awt.*;

public class DrawDemo extends JApplet {
	
	private Random randomNumbers = new Random();
	private MyLine[] lines;
	private MyRectangle[] retangles;
	private MyOval[] ovals;

	public void init() {

		setBackground( Color.WHITE );

		lines = new MyLine[ randomNumbers.nextInt( 5 ) ];
		retangles = new MyRectangle[ randomNumbers.nextInt( 5 ) ];
		ovals = new MyOval[ randomNumbers.nextInt( 5 ) ];

		for ( int count = 0; count < lines.length; count++ ) {
			
			int x1 = randomNumbers.nextInt( 300 );
			int y1 = randomNumbers.nextInt( 300 );
			int x2 = randomNumbers.nextInt( 300 );
			int y2 = randomNumbers.nextInt( 300 );

			Color color = new Color( randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ) );

			lines[ count ] = new MyLine( x1, y1, x2, y2, color );
		}

		for ( int count = 0; count < retangles.length; count++ ) {
			
			int x1 = randomNumbers.nextInt( 300 );
			int y1 = randomNumbers.nextInt( 300 );
			int x2 = randomNumbers.nextInt( 300 );
			int y2 = randomNumbers.nextInt( 300 );

			Color color = new Color( randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ) );
			boolean fill = randomNumbers.nextBoolean();

			retangles[ count ] = new MyRectangle( x1, y1, x2, y2, color, fill );
		}

		for ( int count = 0; count < ovals.length; count++ ) {
			
			int x1 = randomNumbers.nextInt( 300 );
			int y1 = randomNumbers.nextInt( 300 );
			int x2 = randomNumbers.nextInt( 300 );
			int y2 = randomNumbers.nextInt( 300 );

			Color color = new Color( randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ) );
			boolean fill = randomNumbers.nextBoolean();

			ovals[ count ] = new MyOval( x1, y1, x2, y2, color, fill );
		}
	}

	public void paint( Graphics g ) {

		super.paint( g );

		for( MyLine line: lines ) 
			line.draw( g );

		for( MyRectangle retangle: retangles )
			retangle.draw( g );

		for( MyOval oval: ovals )
			oval.draw( g );
	}
}