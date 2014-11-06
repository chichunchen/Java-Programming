
import classData.ch08.DrawPanel;
import javax.swing.*;

public class TestDraw extends JFrame {

	private JLabel statusBar;
	private DrawPanel panel;

	TestDraw() {

		DrawPanel panel = new DrawPanel();
		add( panel );

		statusBar = new JLabel( panel.getStatus() );
		//statusBar.setPreferredSize( new java.awt.Dimension(100, 20) );
		add( statusBar, java.awt.BorderLayout.SOUTH );
		//System.out.print(panel.getStatus());
	}
	
	public static void main(String[] args) {

		TestDraw draw = new TestDraw();
		draw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
		draw.setSize( 300, 300 );
		draw.setVisible( true );
	}
}