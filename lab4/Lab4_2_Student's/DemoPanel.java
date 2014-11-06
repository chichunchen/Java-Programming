import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import javax.swing.event.*;

public class DemoPanel extends JPanel implements ActionListener
{
	private Image image;
	private JButton next,back;
	private JFrame 	frame;
	private String	path;
	private int i;
	//private int maxSize;
	public DemoPanel( int index, JFrame f )
	{
		frame = f;
	
		i = index;
		path = "images/" + i + ".jpg";
		image = new ImageIcon( path ).getImage();

		back = new JButton("BACK");
		back.addActionListener(this);
		add(back);

		next = new JButton("NEXT");
		next.addActionListener(this);
		add(next);
	}
	public void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		setBackground(Color.black);

		g.drawImage( image, 0, 0, getWidth(), getHeight(), null );
	}


//Handlers
//==================================================================================
//button
		public void actionPerformed(ActionEvent event)
		{
			if( event.getSource() == back ) {

				if( i - 1 >= 0 ) {
					--i;
				} 
				else
					i = 9;
			}
			else if( event.getSource() == next ) {
				
				if( i + 1 <= 9 ) {
					++i;
				}
				else
					i = 0;
			}
			path = "images/" + i + ".jpg";
			image = new ImageIcon( path ).getImage();
			frame.remove( this );
			frame.add( new DemoPanel( i, frame ) );
			
			// important
			frame.revalidate();
		}	
//==================================================================================		
}