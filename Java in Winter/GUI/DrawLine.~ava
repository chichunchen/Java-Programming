import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class DrawLine extends JPanel {
  
  // start attributes
  private Random randomNumbers = new Random();
  private MyLine[] lines;
  // end attributes
  
  public DrawLine() {
    setBackground( Color.WHITE );
    lines = new MyLine[ 5 + randomNumbers.nextInt( 100 ) ];   //create random number of lines
    
    for( int count = 0; count < lines.length; count++ ) {
      int x1 = randomNumbers.nextInt( 300 );
      int y1 = randomNumbers.nextInt( 300 );
      int x2 = randomNumbers.nextInt( 300 );
      int y2 = randomNumbers.nextInt( 300 );
      
      Color color = new Color( randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ), randomNumbers.nextInt( 256 ) );
      
      lines[ count ] = new MyLine( x1, y1, x2, y2, color );
    } 
  }
  
  // start methods
  public void paintComponent(Graphics g) {
    super.paintComponent( g );
    
    for( MyLine line : lines ) line.draw( g );
  }
  
  // end methods
} // end of DrawLine
