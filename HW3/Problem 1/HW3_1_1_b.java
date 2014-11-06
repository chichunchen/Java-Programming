import java.awt.Graphics;
import javax.swing.JPanel;

public class HW3_1_1_b extends JPanel {
	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
		
		int width = getWidth();
		int height = getHeight();
		
		for(int i = 0; i < width; i = i + 10) {
			g.drawLine( 0, 0, i + 1, height - i + 1 );
			g.drawLine( 0, height, i, i );
			g.drawLine( width, 0, i, i );
			g.drawLine( width, height, width - i - 1, i - 1 );
		}
	}
}