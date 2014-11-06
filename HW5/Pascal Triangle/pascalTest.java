import javax.swing.*;

public class pascalTest {
	
	public static void main( String[] args ) {
		
		pascalTriangle pascal = new pascalTriangle();
		JFrame frame = new JFrame( "Pascal Triangle" );
		frame.add( pascal );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 500, 500 );
		frame.setVisible( true );
	}
}