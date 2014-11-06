import javax.swing.JFrame;

public class HW3_1_1_aTest {
	public static void main( String[] args ) {
		//create a panel that contains our drawing
		HW3_1_1_a panel = new HW3_1_1_a();
		
		//create a new frame to hold the panel
		JFrame application = new JFrame();
		
		//set the frame to exit when it is closed
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		application.add( panel );
		application.setSize( 500, 500 );
		application.setVisible( true );
	}
}