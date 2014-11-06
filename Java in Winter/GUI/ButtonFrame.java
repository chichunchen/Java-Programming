import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame{
	private JButton plainJButton;	//button with just text
	private JButton fancyJButton;	//button with icons
	
	//ButtonFrame adds JButtons to JFrame
	public ButtonFrame() {
		super( "Testing Buttons" );
		setLayout( new FlowLayout() );	//set frame layout
		
		plainJButton = new JButton( "Plain Button" );
		add( plainJButton );
		
		Icon baby = new ImageIcon( getClass().getResource( "Baby.png"));		//JButton(String text, Icon icon)
		Icon dog = new ImageIcon( getClass().getResource( "dog.png"));
		fancyJButton = new JButton( "Fancy Button", baby );
		fancyJButton.setRolloverIcon( dog );
		add( fancyJButton );
		
		//create new Button handler for button event handling
		ButtonHandler handler = new ButtonHandler();
		fancyJButton.addActionListener( handler );
		plainJButton.addActionListener( handler );
	}
	
	private class ButtonHandler implements ActionListener {
		//handle button event
		public void actionPerformed( ActionEvent event ) {
			JOptionPane.showMessageDialog( ButtonFrame.this, String.format( "You pressed: %s", event.getActionCommand() ) );		
			//event.getActionCommand: Returns the command string associated with this action.
		}
	}
}