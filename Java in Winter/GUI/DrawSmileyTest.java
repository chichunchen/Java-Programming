import javax.swing.JFrame;

public class DrawSmileyTest {
	public static void main( String[] args ) {
		//create a panel that contains our drawing
		DrawSmiley panel = new DrawSmiley();
		
		//create a new frame to hold the panel
		JFrame application = new JFrame();
		
		//set the frame to exit when it is closed
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		application.add( panel );
		application.setSize( 230, 250 );
		application.setVisible( true );
	}
}