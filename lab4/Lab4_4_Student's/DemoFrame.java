import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import javax.swing.event.*;

public class DemoFrame extends JFrame
{
	private JFrame frame1,frame2;
	private JButton first,second;
	private DemoPanel panel1,panel2,myPanel;
	public boolean f,s;
	public DemoFrame()
	{	
		myPanel = new DemoPanel( 3, this );
		panel1 = new DemoPanel( 4, this );
		panel2 = new DemoPanel( 5, this );
		
		//setLayout( new FlowLayout() );
		add( myPanel );
		
		f = true;
		s = true;
		
	}
	public void closeFirst()
	{
		f = true;
		frame1.dispose();
	}
	public void closeSecond()
	{
		s = true;
		frame2.dispose();
	}
	public void addfirst()
	{
		if( f == true ) {
			frame1 = new JFrame( "First Window" );

			frame1.add( panel1 );
			frame1.setSize( 500, 500 );
			frame1.setVisible( true );
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			f = false;
		}
		else
			closeFirst();
	}
	public void addsecond()
	{
		if( s == true ) {
			frame2 = new JFrame( "Second Window" );
		
			frame2.add( panel2 );
			frame2.setSize( 500, 500 );
			frame2.setVisible( true );
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			s = false;
		}
		else
			closeSecond();
	}
//==================================================================================
}

