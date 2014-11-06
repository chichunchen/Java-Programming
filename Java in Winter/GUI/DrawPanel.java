import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
		
		int width = getWidth();
		int height = getHeight();
		
		for(int i = 0; i < width; i = i + 10) {
			g.drawLine( 0, i, i, height );
			g.drawLine( i, 0, 0, height - i );
			g.drawLine( i, 0, width, i );
			g.drawLine( width - i, height, width, i );
		}
	}
}