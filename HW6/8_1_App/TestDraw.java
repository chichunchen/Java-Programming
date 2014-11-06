
import classData.ch08.DrawPanel;
import javax.swing.*;

public class TestDraw {
	
	public static void main(String[] args) {
		
		DrawPanel panel = new DrawPanel();
		JFrame application = new JFrame( "HW6_1" );

		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
		application.add( panel );
		application.setSize( 300, 300 );
		application.setVisible( true );
	}
}