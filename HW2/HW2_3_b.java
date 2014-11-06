import java.awt.*;
import javax.swing.*;

public class HW2_3_b extends JApplet {

	private int numbers[] = new int[100];

	public void bubblesort() {    
		int size = numbers.length;   
		int x, y, temp;
	
		for(x = 0; x < size-1; x++) {
			for(y = 0; y < size - 1 - x; y++) {
				if(numbers[y] > numbers[y+1]) {
					temp = numbers[y];
					numbers[y] = numbers[y+1];
					numbers[y+1] = temp;
				}
			}
		}
	}

	public void init() {

		//random numbers into numbers array
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*101);
		}

	}

	public void paint( Graphics g ) {
		super.paint( g );

		g.setColor( Color.magenta );

		for(int i = 0; i < numbers.length; i++) {
			g.drawLine( 10, 20 + 3 * i, 10 + numbers[i], 20 + 3 * i );
		}
		g.drawString("The original array", 10, 350);

		bubblesort();

		for( int j = 0; j < numbers.length; j++ ) {
            g.drawLine( 225, 20 + 3 * j, 225 + numbers[j], 20 + 3 * j );
        }
        g.drawString("The sorted array", 225,350);     

        	
	}

}