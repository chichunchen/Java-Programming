// Fig. 6.16: FibonacciTest.java
// Recursive fibonacci method.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FibonacciTest extends JApplet implements ActionListener {
   JLabel numberLabel, resultLabel;
   JTextField numberField, resultField;
   public void init()
   { Container container = getContentPane();
      container.setLayout( new FlowLayout() );
      numberLabel = new JLabel( "Enter an integer and press Enter" );
      container.add( numberLabel );
      numberField = new JTextField( 10 );
      container.add( numberField );
      numberField.addActionListener( this );

      resultLabel = new JLabel( "Fibonacci value is" );
      container.add( resultLabel );
      resultField = new JTextField( 15 );
      resultField.setEditable( false );
      container.add( resultField );    
   } // end method init

   public void actionPerformed( ActionEvent event )
   {  long number, fibonacciValue;
      number = Long.parseLong( numberField.getText() );
      // the same as   number = Long.parseLong( event.getActioCommand());

      showStatus( "Calculating ..." ); 
      fibonacciValue = fibonacci( number );
      showStatus( "Done." );   
      resultField.setText( Long.toString( fibonacciValue ) );   } 

   public long fibonacci( long n )
   { if ( n == 0 || n == 1 )  
         return n;
      else
         return fibonacci( n - 1 ) + fibonacci( n - 2 );
  }
}

