import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import javax.swing.event.*;

public class DemoPanel extends JPanel implements ActionListener
{
	private Image image;
	private JButton first,second;
	private JPanel	myPanel;
	private DemoFrame frame;
	private String	path;
	private int i;
	public DemoPanel( int index, DemoFrame f)
	{
		frame = f;
		i = index;
		path = "images/" + i + ".jpg";
	
		first = new JButton("first");
		first.addActionListener(this);
		add(first);
		
		second = new JButton("second");
		second.addActionListener(this);
		add(second);
		//
		
		image = new ImageIcon( path ).getImage();
	}
	public void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		
		g.drawImage( image, 0, 0, getWidth(), getHeight(), null );
	}


//Handlers
//==================================================================================
//button
		public void actionPerformed(ActionEvent event)
		{
			if( event.getSource() == first ) {
				frame.addfirst();
			}
			else if ( event.getSource() == second ) {
				frame.addsecond();
			}
		}	
//==================================================================================		
}