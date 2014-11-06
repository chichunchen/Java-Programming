import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeckOfCards extends JFrame {
	
	private Card[] deck;
	private Card[] hand;
	private int currentCard;
	private JButton dealButton, shuffleButton;
	private JTextArea displayCard, status;
	private int numbers[], couples, triples;
	private String faces[], suits[], output;
	private static final int NUMBER_OF_CARDS = 52;
	private static final int NUMBER_OF_HANDCARDS = 5;
	private static final Random ramndomNumbers = new Random();
	//private JLabel cardLefts;

	public DeckOfCards() {

		super( "Card Dealing Program" );

		String faceArray[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
		String suitArray[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

		faces = faceArray;
		suits = suitArray;

		numbers = new int[ 13 ];
		couples = 0;
		triples = 0;

		deck = new Card[ NUMBER_OF_CARDS ];
		hand = new Card[ NUMBER_OF_HANDCARDS ];

		currentCard = 0;

		//initialize the deck array
		for( int count = 0; count < deck.length; count++ ) {
			deck[ count ] = new Card( faces[ count % 13 ], suits[ count / 13 ] );
		}

		Container container = getContentPane();
		container.setLayout( new FlowLayout() );

		dealButton = new JButton( "Deal hand" );
		dealButton.addActionListener(

			new ActionListener() {

				public void actionPerformed( ActionEvent e ) {
					displayCard.setText( "" );
					output = "";

					couples = 0;
					triples = 0;

					for( int i = 0; i < NUMBER_OF_HANDCARDS; i++ ) {
						hand[ i ] = dealCard();
						output += hand[ i ];
						output += "\n";
					}
					displayCard.setText( output );
					//System.out.println( currentCard );
					output = pair();
					output += "\n";
					output += kind();
					output += "\n";
					output += fullHouse();
					output += "\n";
					output += straight();
					status.setText( output );
				}

			}
		);
		container.add( dealButton );

		shuffleButton = new JButton( "Shuffle cards" );
		shuffleButton.addActionListener(

			new ActionListener() {

				public void actionPerformed( ActionEvent e ) {
					displayCard.setText( "SHUFFLING" );
					shuffle();
					displayCard.setText( "DECK IS SHUFFLING" );
				}

			}

		);
		container.add( shuffleButton );

		displayCard = new JTextArea( 6, 20 );
		displayCard.setEditable( false );
		container.add( displayCard );

		status = new JTextArea( 2, 20 );
		status.setEditable( false );
		container.add( status );
	}

	public void shuffle() {

		//after shuffling, dealing should start at deck[ 0 ] again
		currentCard = 0;

		for( int first = 0; first < deck.length; first++ ) {
			int second = ramndomNumbers.nextInt( NUMBER_OF_CARDS );

			Card temp = deck[ first ];
			deck[ first ] = deck[ second ];
			deck[ second ] = temp;
		}
	}

	public Card dealCard() {

		if( currentCard < deck.length ) 
			return deck[ currentCard++ ];
		else
			return null;
	}

	public String pair() {
		int pairNum = 0;
		String result;

		for( int i = 0; i < NUMBER_OF_HANDCARDS - 1; i++ ) {
			for( int j = i+1; j < NUMBER_OF_HANDCARDS; j++ ) {
				if( hand[ i ].getFace() == hand[ j ].getFace() )
					pairNum++;
			}
		}
		
		if( pairNum == 1 ) {
			couples = 1;
			result = "a pair";
		}
		else if( pairNum == 2 ) {
			couples = 2;
			result = "two pairs";
		}
		else result = "no pair";

		return result;
	}

	public String kind() {
		int[] kindNumber = { 0, 0, 0, 0 };
		int maxKind = 0;

		String result = "";

		for( int i = 0; i < NUMBER_OF_HANDCARDS; i++ ) {
			switch( hand[ i ].getSuit() ) {
				case "Hearts": 
					kindNumber[ 0 ]++;
					break;
				case "Diamonds":
					kindNumber[ 1 ]++;
					break;
				case "Clubs":
					kindNumber[ 2 ]++;
					break;
				case "Spades":
					kindNumber[ 3 ]++;
					break;
			}
		}

		for( int i = 0; i < 3; i++ ) {
			if( kindNumber[ i ] < kindNumber[ i + 1 ] )
				maxKind = kindNumber[ i + 1 ];
		}

		if( maxKind == 3 )
			result = "three of a kind";
		else if ( maxKind == 4 )
			result = "four of a kind";
		else if ( maxKind == 5 )
			result = "flush";

		return result;
	}

	private void totalHand() {

		for( int x = 0; x < faces.length; x++ ) 
			numbers[ x ] = 0;

		for( int h = 0; h < hand.length; h++ )
			for( int f = 0; f < faces.length; f++ )
				if( hand[ h ].getFace().equals( faces[ f ] ) )
					++numbers[ f ];
	}

	public void faceSort( int values[] ) {
		for ( int pass = 1; pass < values.length; pass++ )
			
			for ( int comp = 0; comp < values.length - 1; comp++ ) 
				if ( values[ comp ] > values[ comp + 1 ] ) {
					int temp = values[ comp ];
					values[ comp ] = values[ comp + 1 ];
					values[ comp + 1 ] = values[ comp ];
				}
	}

	public String straight() {
		int locations[] = new int[ 5 ], z = 0;

		for( int y = 0; y < numbers.length; y++ ) 
			if( numbers[ y ] == 1 )
				locations[ z++ ] = y;

		faceSort( locations );

		int faceValue = locations[ 0 ];

		for ( int m = 1; m < locations.length; m++ ) {
			if( faceValue != locations[ m ] - 1 )
				return "";
			else 
				faceValue = locations[ m ];
		}
		
		return "Straight";
	}

	public String fullHouse() {

		String face1 = hand[ 0 ].getFace() , face2;
		int count1 = 0, count2 = 0, i, j;

		for( i = 1; i < NUMBER_OF_HANDCARDS; i++ ) {
			if( face1 == hand[ i ].getFace() ) {
				count1++;
			}
			else {
				break;
			}
		}

		face2 = hand[ i ].getFace();

		for( j = i; j < NUMBER_OF_HANDCARDS; j++ ) {
			if( face1 == hand[ j ].getFace() ) {
				count1++;
			}
			else if ( face2 == hand[ j ].getFace() ) {
				count2++;
			}
		}

		if( count1 == 2 && count2 == 3 || count1 == 3 && count2 == 2 ) {
			return "Full House";
		}
		else
			return "";
	}

}