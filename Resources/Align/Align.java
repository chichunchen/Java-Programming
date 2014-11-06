// Exercise 13.8 Solution: Align.java
// Program creates a simple GUI.
import java.awt.*;
import javax.swing.*;

public class Align extends JFrame {
   private JButton okButton, cancelButton, helpButton;
   private JTextField xValue, yValue;
   private JCheckBox snapBox, showBox;
   private JLabel xLabel, yLabel;
   private JPanel checkPanel, buttonPanel, fieldPanel1, 
      fieldPanel2, fieldPanel;

   // constructor sets up GUI
   public Align()
   {
      super( "Align" );

      // build checkPanel
      snapBox = new JCheckBox( "Snap to Grid" );
      showBox = new JCheckBox( "Show Grid" );
      checkPanel = new JPanel();
      checkPanel.setLayout( new GridLayout( 2 , 1 ) );
      checkPanel.add( snapBox );
      checkPanel.add( showBox );

      // build field panel1
      xLabel = new JLabel( "X: " );
      xValue = new JTextField( "8", 3 );
      fieldPanel1 = new JPanel();
      fieldPanel1.setLayout( new FlowLayout() );
      fieldPanel1.add( xLabel );
      fieldPanel1.add( xValue );

      // build field panel2
      yLabel = new JLabel( "Y: " );
      yValue = new JTextField( "8", 3 );
      fieldPanel2 = new JPanel();
      fieldPanel2.setLayout( new FlowLayout() );
      fieldPanel2.add( yLabel );
      fieldPanel2.add( yValue );

      // build field panel
      fieldPanel = new JPanel();
      fieldPanel.setLayout( new BorderLayout() );
      fieldPanel.add( fieldPanel1, BorderLayout.NORTH );
      fieldPanel.add( fieldPanel2, BorderLayout.SOUTH );

      // build button panel
      okButton = new JButton( "Ok" );
      cancelButton = new JButton( "Cancel" );
      helpButton = new JButton( "Help" );
      buttonPanel = new JPanel();
      buttonPanel.setLayout( new GridLayout( 3, 1, 10, 5 ) );
      buttonPanel.add( okButton );
      buttonPanel.add( cancelButton );
      buttonPanel.add( helpButton );

      // set layout for applet
      Container container = getContentPane();
      container.setLayout(
         new FlowLayout( FlowLayout.CENTER, 10, 5 ) );
      container.add( checkPanel );
      container.add( fieldPanel );
      container.add( buttonPanel );

      setSize( 300, 125 );
      setVisible( true );

   }  // end Align constructor

   // execute application
   public static void main( String args[] )
   {
      Align application = new Align();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

}  // end class Align
