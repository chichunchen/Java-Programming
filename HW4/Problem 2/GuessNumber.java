import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GuessNumber extends JApplet implements ActionListener {
	
	private JLabel promptLabel;
	private JTextField guessField;
	private JButton enterButton;
	private JLabel statucBar;
	private int answer;
	
	private int randomNumber() {
		return (int)( Math.random() * 1000 );
	}
	
	private String guessTest( String guess ) {
		String win = "Congratulations. You guessed the number!!";
		String tooHigh = "Too high. Try again. ";
		String tooLow = "Too low. Try again. ";
		
		int guessNum = Integer.parseInt( guess );
		if( guessNum == answer ) return win;
		else if ( guessNum < answer ) return tooLow;
		else return tooHigh;
	}
	
	public void init() {
		answer = randomNumber();
	
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
		
		promptLabel = new JLabel( "Guess a number between 1 and 1000" );
		container.add( promptLabel );
		
		guessField = new JTextField( 8 );
		container.add( guessField );
		
		enterButton = new JButton( "Enter" );
		enterButton.addActionListener( this );
		container.add( enterButton );
		
		statucBar = new JLabel( "" );
		container.add( statucBar );
	}
	
	public void actionPerformed( ActionEvent event ) {
		if( event.getSource() == enterButton ) {
			String guessResult = guessTest( guessField.getText() );
			statucBar.setText( guessResult );
			guessField.setText( "" );
		}
	}
	
}