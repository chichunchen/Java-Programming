import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import javax.swing.event.*;

public class DemoFrame extends JFrame implements ActionListener
{
	private JFrame frame;
	private JButton enter;
	private JTextField inputBox;
	private int index;
	private DemoPanel panel;
	public DemoFrame()
	{
		super( "FirstWindow" );
		setLayout( new FlowLayout() );

		enter = new JButton("enter");
		inputBox = new JTextField(20);
		enter.addActionListener(this);
		add(enter); 	
		add(inputBox);
	}
//Handlers
//==================================================================================
//button
	public void actionPerformed(ActionEvent e)
	{
		String content = inputBox.getText();

		if( isNumeric( content ) && index >=0 && index <= 9 ) {

			frame = new JFrame( "Second Window" );
			//frame.setLayout( new FlowLayout() );
			
			panel = new DemoPanel( index, frame );
			frame.add( panel );
			
			Dimension d = getMaximumSize(); 
			frame.setSize(d.width, d.height);

			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else {
			System.out.println( "error input" );
		}
	}
//==================================================================================

	public boolean isNumeric( String str ) {
		try {
			int d = Integer.parseInt( str );
			index = d;
		}
		catch( NumberFormatException nfe ) {
			return false;
		}
		return true;
	}
}

