// Fig. 6.9: Craps.java
// Craps.
import java.awt.*;        // Container, FlowLayout
import java.awt.event.*;  // ActionEvent, ActionListener

import javax.swing.*;     // JApplet, JButton, JLabel, JTextField

public class Craps extends JApplet implements ActionListener {

   // constant variables for game status
   final int WON = 0, LOST = 1, CONTINUE = 2; 
   
   boolean firstRoll = true;  // true if first roll of dice
   int sumOfDice = 0;         // sum of the dice
   int myPoint = 0;           // point if no win or loss on first roll
   int gameStatus = CONTINUE; // game not over yet

   // graphical user interface components 
   JLabel die1Label, die2Label, sumLabel, pointLabel;
   JTextField die1Field, die2Field, sumField, pointField;
   JButton rollButton;

   // set up GUI components
   public void init()
   {
      // obtain content pane and change its layout to FlowLayout
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );      

      // create label and text field for die 1
      die1Label = new JLabel( "Die 1" );
      container.add( die1Label );
      die1Field = new JTextField( 10 );
      die1Field.setEditable( false );
      container.add( die1Field );

      // create label and text field for die 2
      die2Label = new JLabel( "Die 2" );
      container.add( die2Label );
      die2Field = new JTextField( 10 );
      die2Field.setEditable( false );
      container.add( die2Field );

      // create label and text field for sum
      sumLabel = new JLabel( "Sum is" );
      container.add( sumLabel );
      sumField = new JTextField( 10 );
      sumField.setEditable( false );
      container.add( sumField );

      // create label and text field for point
      pointLabel = new JLabel( "Point is" );
      container.add( pointLabel );
      pointField = new JTextField( 10 );
      pointField.setEditable( false );
      container.add( pointField );

      // create button user clicks to roll dice
      rollButton = new JButton( "Roll Dice" );
      rollButton.addActionListener( this );
      container.add( rollButton );

   } // end method init

   // process one roll of dice
   public void actionPerformed( ActionEvent actionEvent )
   {
      sumOfDice = rollDice();  // roll dice
      
      // first roll of dice
      if ( firstRoll ) {               
   
         switch ( sumOfDice ) {

            // win on first roll
            case 7: 
            case 11:         
               gameStatus = WON;
               pointField.setText( "" );  // clear point field
               break;

            // lose on first roll
            case 2: 
            case 3: 
            case 12: 
               gameStatus = LOST;
               pointField.setText( "" );  // clear point field
               break;

            // remember point
            default:                 
               gameStatus = CONTINUE;
               myPoint = sumOfDice;
               pointField.setText( Integer.toString( myPoint ) );
               firstRoll = false;
               break;

         } // end switch 

      } // end if part of if...else

      else { // subsequent roll of dice
          
         // determine game status
         if ( sumOfDice == myPoint )  // win by making point
            gameStatus = WON;
         else
            if ( sumOfDice == 7 )     // lose by rolling 7
               gameStatus = LOST;

      } // end else part of if...else

      displayMessage();   // display message indicating game status

   } // end method actionPerformed

   // roll dice, calculate sum and display results
   public int rollDice()
   {
      // pick random die values
      int die1 = 1 + ( int ) ( Math.random() * 6 );  
      int die2 = 1 + ( int ) ( Math.random() * 6 );

      int sum = die1 + die2;   // sum die values

      // display results in textfields
      die1Field.setText( Integer.toString( die1 ) );
      die2Field.setText( Integer.toString( die2 ) );
      sumField.setText( Integer.toString( sum ) );

      return sum;  // return sum of dice

   } // end method rollDice
   
   // determine game status; display appropriate message in status bar
   public void displayMessage()
   {
      // game should continue
      if ( gameStatus == CONTINUE )
         showStatus( "Roll again." );

      else { // game won or lost

         if ( gameStatus == WON )
            showStatus( "Player wins. Click Roll Dice to play again." );
         else 
            showStatus( "Player loses. Click Roll Dice to play again." );
         
         firstRoll = true;  // next roll is first roll of new game

      } // end else part of if...else

   } // end method displayMessage

} // end class Craps


/**************************************************************************
 * (C) Copyright 1992-2003 by Deitel & Associates, Inc. and               *
 * Prentice Hall. All Rights Reserved.                                    *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
