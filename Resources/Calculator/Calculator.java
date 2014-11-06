// Solution exercise 13.9: Calculator.java
// Program creates a GUI that resembles a calculator.
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame {
   private JButton keys[];
   private JPanel keyPad;
   private JTextField lcd;

   // constructor sets up GUI
   public Calculator()
   {
      super( "Calculator" );

      lcd = new JTextField( 20 );
      lcd.setEditable( true );

      keys = new JButton[ 16 ];

      // initialize all non-digit key Buttons
      for ( int i = 0; i <= 9; i++ )
         keys[ i ] = new JButton( String.valueOf( i ) );

      // initialize all digit key Buttons
      keys[ 10 ] = new JButton( "/" );
      keys[ 11 ] = new JButton( "*" );
      keys[ 12 ] = new JButton( "-" );
      keys[ 13 ] = new JButton( "+" );
      keys[ 14 ] = new JButton( "=" );
      keys[ 15 ] = new JButton( "." );

      // set keyPad layout to grid layout
      keyPad = new JPanel();
      keyPad.setLayout( new GridLayout( 4, 4 ) );

      // add buttons to keyPad panel
      // 7, 8, 9, divide
      for ( int i = 7; i <= 10; i++ )
         keyPad.add( keys[ i ] );

      // 4, 5, 6
      for ( int i = 4; i <= 6; i++ )
         keyPad.add( keys[ i ] );

      // multiply
      keyPad.add( keys[ 11 ] );

      // 1, 2, 3
      for ( int i = 1; i <= 3; i++ )
         keyPad.add( keys[ i ] );

      // subtract
      keyPad.add( keys[ 12 ] );

      // 0
      keyPad.add( keys[ 0 ] );

      // ., =, add
      for ( int i = 15; i >= 13; i-- )
         keyPad.add( keys[ i ] );

      // add components to (default) border layout
      Container container = getContentPane();
      container.add( lcd, BorderLayout.NORTH );
      container.add( keyPad, BorderLayout.CENTER );

      setSize( 200, 200 );
      setVisible( true );

   }  // end Calculator constructor

   // execute application
   public static void main( String args[] )
   {
      Calculator application = new Calculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

}  // end class Calculator

