import javax.swing.JFrame;

public class panelTest {
	public static void main( String[] args ) {
		JFrame frame = new JFrame( "Lab3(2) Demo" );
		panel pp = new panel();
		frame.add( pp );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 500, 500 );
		frame.setVisible( true );
	}
}