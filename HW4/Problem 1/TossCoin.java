import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TossCoin extends JFrame implements ActionListener {
	
	private JButton tossButton;
	private JTextField trueField;
	private JTextField falseField;
	private JLabel trueLabel;
	private JLabel falseLabel;
	private int countHeads;
	private int countTails;
	
	public TossCoin() {
		super( "TossCoin" );
		setLayout( new FlowLayout() );
		
		countHeads = 0;
		countTails = 0;
		
		trueLabel = new JLabel( "Heads" );
		add( trueLabel );
		
		trueField = new JTextField( 10 );
		trueField.setEditable( false );
		add( trueField );
		
		falseLabel = new JLabel( "Tails" );
		add( falseLabel );
		
		falseField = new JTextField( 10 );
		falseField.setEditable( false );
		add( falseField );
		
		tossButton = new JButton( "Toss" );
		add( tossButton );
		tossButton.addActionListener( this );
	}
	
	public boolean flip() {
		Random rand = new Random();
		int x = rand.nextInt( 2 ); 
		System.out.print("random x " + x + "\n" );
		
		if ( x == 1 ) 
			return true;
		else 
			return false;
	}
	
	public void actionPerformed( ActionEvent event ) {
		boolean result = flip();
		
		if( result == true )  {
			countHeads++;
			trueField.setText( Integer.toString( countHeads ) );
		}
		else {
			countTails++;
			falseField.setText( Integer.toString( countTails ) );
		}
	}
}