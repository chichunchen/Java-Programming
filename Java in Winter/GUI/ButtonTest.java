import javax.swing.JFrame;

public class ButtonTest {
	public static void main( String[] args ) {
		ButtonFrame buttonFrame = new ButtonFrame();
		buttonFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		buttonFrame.setSize( 275, 300 );
		buttonFrame.setVisible( true );
	}
}