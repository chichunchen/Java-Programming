import javax.swing.*; 
import java.awt.*; 
import java.util.Scanner;
import java.awt.event.*; 
  
public class lab2_4Test extends JFrame { 
      
	int number;
	 
	lab2_4Test() {
		askInput();
	}
	 
	public void askInput() { 
        System.out.print( "Input number 0 to draw rectangle or 1 to draw circle: " ); 
        Scanner input = new Scanner( System.in ); 
        number = input.nextInt(); 
    } 
	  
    public static void main( String[] args ) { 
      
		lab2_4Test l= new lab2_4Test();
		lab2_4 panel = new lab2_4( l.number, l ); 

		l.add( panel ); 
		l.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        l.setSize( 500, 500 ); 
        l.setVisible( true );   
    } 
}