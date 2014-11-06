

// Fig. 8.8: TimeTest5.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeTest5 extends JApplet implements ActionListener {
   private Time3 time;
   private JLabel hourLabel, minuteLabel, secondLabel;
   private JTextField hourField, minuteField, secondField, displayField;
   private JButton tickButton;
   public void init()
   {  time = new Time3();  // create Time5 object
      Container container = getContentPane();  
      container.setLayout( new FlowLayout() ); 
      hourLabel = new JLabel( "Set Hour" );
      hourField = new JTextField( 10 );
      container.add( hourLabel );
      container.add( hourField );
      minuteLabel = new JLabel( "Set Minute" );
      minuteField = new JTextField( 10 );
      container.add( minuteLabel );
      container.add( minuteField );
      secondLabel = new JLabel( "Set Second" );
      secondField = new JTextField( 10 );
      container.add( secondLabel );
      container.add( secondField );
      displayField = new JTextField( 30 );
      displayField.setEditable( false );
      container.add( displayField );
      tickButton = new JButton( "Add 1 to Second" );
      container.add( tickButton );
      hourField.addActionListener( this ); 
      minuteField.addActionListener( this );
      secondField.addActionListener( this );
      tickButton.addActionListener( this );
      displayTime(); // update text in displayField and status bar
   } 
   // event handler for button and textfield events
   public void actionPerformed( ActionEvent event )
   {  if ( event.getSource() == tickButton )
         tick();
      else if ( event.getSource() == hourField ) {
         time.setHour( Integer.parseInt( event.getActionCommand() ) );
         hourField.setText( "" );      }
      else if ( event.getSource() == minuteField ) {
         time.setMinute( Integer.parseInt( event.getActionCommand() ) );
         minuteField.setText( "" );      }
      else if ( event.getSource() == secondField ) {
         time.setSecond( Integer.parseInt( event.getActionCommand() ) );
         secondField.setText( "" );      }
      displayTime();} // update text in displayField and status bar 
 
    public void displayTime()
   {  displayField.setText( "Hour: " + time.getHour() + "; Minute: " + 
         time.getMinute() + "; Second: " + time.getSecond() );
      showStatus( " Universal time is: " + time.toUniversalString() );   } 

   public void tick()
   { time.setSecond( ( time.getSecond() + 1 ) % 60 );
      if ( time.getSecond() == 0 ) {
         time.setMinute( ( time.getMinute() + 1 ) % 60 );
      if ( time.getMinute() == 0 )
            time.setHour( ( time.getHour() + 1 ) % 24 );  }
   }
}





