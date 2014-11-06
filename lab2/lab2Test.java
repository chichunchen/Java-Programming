import javax.swing.*;
import java.util.Scanner;
import java.awt.Color;

public class lab2Test extends JFrame {
	
	private int ans;
	
	public lab2Test() {
		ans = AskInput();
	}
	
	public int AskInput() {
		System.out.println( "Input 0~10: " );
		Scanner input = new Scanner( System.in );
		return input.nextInt();
	}
	
	public static void main( String[] args ) {
		
		lab2Test frame = new lab2Test();
		lab2 panel = new lab2( frame.ans, frame );
		
		frame.setSize( 500, 500 );
		frame.add( panel );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible( true );
				
	}
}