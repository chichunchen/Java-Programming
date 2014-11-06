import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pascalTriangle extends JPanel {
	
	private JButton enterButton;
	private JTextField inputField;
	private int maxRows;
	private int triangle[][];
	
	public pascalTriangle() {
		
		inputField = new JTextField( 8 );
		add( inputField );
	
		enterButton = new JButton( "Enter" );
		add( enterButton );
		
		ButtonHandler handler = new ButtonHandler();
		enterButton.addActionListener( handler );
		
	}
	
	public void generateTriangle() {
		
		int leftOne, rightOne;
		
		triangle[ 0 ][ maxRows - 1 ] = 1;
		leftOne = rightOne = maxRows - 1;
		
		for ( int i = 1; i < maxRows; i++ )
        {
            leftOne--;
            rightOne++;
            triangle[i][leftOne] = 1;
            triangle[i][rightOne] = 1;

            for (int c = 1; c <= i; c++)
            {
                int left = triangle[i - 1][leftOne + (2 * c) - 1];
                int right = triangle[i - 1][leftOne + (2 * c) + 1];
                triangle[i][leftOne + (2 * c)] = left + right;
            }
        }
	}
	
	public void print2DArray( int triangle[][] ) {
	
		Graphics g = getGraphics();
		super.paintComponent( g );
		
		int x = 0;
		int y = 60;
		
		Font font = new Font( "Serif", Font.PLAIN, 20 );
		g.setFont( font );
	
		for( int[] pascal: triangle ) {
			for( int val: pascal ) {
			
				if( val == 0 ) 
					g.drawString( "", x, y );
				else {					
					g.drawString( Integer.toString( val ), x, y );
					
					int divide = 10;
					while( val / divide >= 1 ) {
						x += 10;
						divide *= 10;
					}
				}
				
				x += 10;
			}
			x = 0;
			y += 16;
		}
	}
	
	private class ButtonHandler implements ActionListener {
		
		public void actionPerformed( ActionEvent event ) {
			
			int n = Integer.parseInt( inputField.getText() );
			
			if( n >= 1 ) {
				maxRows = n;
				triangle = new int[ maxRows + 1 ][ (maxRows + 1) * 2 ];
				generateTriangle();
				print2DArray( triangle );
			}
			else {
				JOptionPane.showMessageDialog( null, "Input must greater equal than 1", "Input >= 1", JOptionPane.PLAIN_MESSAGE );
			}
		}
	}
	
}