import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TurtleGraphics extends JApplet implements ActionListener {
	
	final int MAXCOMMANDS = 100;
	final int SIZE = 20;
	JLabel prompt;
	JTextField input;
	JTextArea output;
	int floor[][];
	int commandArray[][];
	int command, distance, direction, count, xPos, yPos;
	boolean penDown;
	
	public void init() {
	
		prompt = new JLabel( "Enter command (9 to end input): " );
		input = new JTextField( 4 );
		input.addActionListener( this );
		
		output = new JTextArea( 25, 40 );
		output.setFont( new Font( "Monospaced", Font.PLAIN, 16 ) );
		
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
		container.add( prompt );
		container.add( input );
		container.add( output );
		
		direction = 0;
		count = 0;
		xPos = 0;
		yPos = 0;
		penDown = false;
		
		floor = new int[ SIZE ][SIZE ];
		commandArray = new int[ MAXCOMMANDS ][ 2 ];
		
	}
	
	public void actionPerformed( ActionEvent actionEvent ) {
		
		if( actionEvent.getSource() == input ) {
			int inputCommand = Integer.parseInt( input.getText() );
			input.setText( "" );
			
			if( count < MAXCOMMANDS ) {
				commandArray[ count ][ 0 ] = inputCommand;
				
				if( inputCommand == 5 ) {
					int spaces = Integer.parseInt( JOptionPane.showInputDialog( "Enter forward spaces" ) );
					commandArray[ count ][ 1 ] = spaces;
				}
			}
			
			count++;
			
			if( inputCommand == 9 || count == MAXCOMMANDS )
				executeCommand();
		}
		
	}
	
	public void executeCommand() {
		int commandNumber = 0;
		command = commandArray[ commandNumber ][ 0 ];
		
		while( command != 9 && commandNumber < MAXCOMMANDS ) {
			
			switch( command ) {
				case 1:
					penDown = false;
					break;
				case 2:
					penDown = true;
					break;
				case 3:
					direction = turnRight( direction );
					break;
				case 4:
					direction = turnLeft( direction );
					break;
				case 5: 
					distance = commandArray[ commandNumber ][ 1 ];
					movePen( penDown, floor, direction, distance );
					break;
				case 6: 
					output.append( "\nThe drawing is: \n\n" );
					printArray( floor );
					break;
			}
			
			command = commandArray[ ++commandNumber ][ 0 ];
		}
	}
	
	public int turnRight( int d ) {
		return ++d > 3 ? 0 : d;
	}
	
	public int turnLeft( int d ) {
		return --d < 0 ? 3 : d;
	}
	
	public void movePen( boolean down, int a[][], int dir, int dist ) {
		int j;
		
		switch( dir ) {
		
			//move to right
			case 0:
				for( j = 1; j <= dist && yPos + j < SIZE; ++j )
					if( down )
						a[ xPos ][ yPos + j ] = 1;
				yPos += j - 1;
				break;
			
			//move to down
			case 1:
				for( j = 1; j <= dist && xPos + j < SIZE; ++j )
					if( down )
						a[ xPos + j ][ yPos ] = 1;
				xPos += j - 1;
				break;
			
			//move to left
			case 2:
				for( j = 1; j <= dist && yPos - j >= 0; ++j )
					if( down )
						a[ xPos ][ yPos - j ] = 1;
				yPos -= j - 1;
				break;
			
			//move to up
			case 3:
				for( j = 1; j <= dist && xPos - j >= 0; ++j )
					if( down )
						a[ xPos - j ][ yPos ] = 1;
				xPos -= j - 1;
				break;
		}
	}
	
	public void printArray( int a[][] ) {
		for( int i = 0; i < SIZE; ++i ) {
			for( int j = 0; j < SIZE; j++ )
				output.append( ( a[ i ][ j ] == 1 ? "*" : " " ) );
			output.append( "\n" );
		}
	}
}