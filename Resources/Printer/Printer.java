// Exercise 13.12 Solution: Printer.java
// This program creates a simple Printer GUI
import java.awt.*;
import javax.swing.*;

public class Printer extends JFrame {
   private JButton button1, button2, button3, button4;
   private JCheckBox check1, check2, check3, check4;
   private JRadioButton radio1, radio2, radio3;
   private ButtonGroup radioGroup;
   private JComboBox comboBox;
   private JLabel label1, label2;
   private JPanel panel1, panel2, panel3, panel4, panel5,
      panel6, panel7, panel8;

   // constructor sets up GUI
   public Printer()
   {
      super( "Printer" );

      // build left north panel
      label1 = new JLabel( "Printer: MyPrinter" );
      panel1 = new JPanel();
      panel1.setLayout( new FlowLayout( FlowLayout.LEFT ) );
      panel1.add( label1 );

      // build right east panel
      button1 = new JButton( "OK" );
      button2 = new JButton( "Cancel" );
      button3 = new JButton( "Setup..." );
      button4 = new JButton( "Help" );
      panel2 = new JPanel();
      panel2.setLayout( new GridLayout( 4, 1, 5, 5 ) );
      panel2.add( button1 );
      panel2.add( button2 );
      panel2.add( button3 );
      panel2.add( button4 );

      // build left south panel
      label2 = new JLabel( "Print Quality: " );
      comboBox = new JComboBox();
      comboBox.addItem( "High" );
      check1 = new JCheckBox( "Print to File" );
      panel3 = new JPanel();
      panel3.setLayout( new FlowLayout( FlowLayout.CENTER, 10, 0 ) );
      panel3.add( label2 );
      panel3.add( comboBox );
      panel3.add( check1 );

      // build left east panel
      check2 = new JCheckBox( "Image" );
      check3 = new JCheckBox( "Text" );
      check4 = new JCheckBox( "Code" );
      panel4 = new JPanel();
      panel4.setLayout( new BorderLayout( ) );
      panel4.add( check2, BorderLayout.NORTH );
      panel4.add( check3, BorderLayout.CENTER );
      panel4.add( check4, BorderLayout.SOUTH );

      // build left west panel
      panel5 = new JPanel();
      panel5.setLayout( new BorderLayout() );
      panel5.add( radio1 = new JRadioButton( "Selection",
         false ), BorderLayout.NORTH );
      panel5.add( radio2 = new JRadioButton( "All", true ),
         BorderLayout.CENTER );
      panel5.add( radio3 = new JRadioButton( "Applet", false ),
         BorderLayout.SOUTH );

      // group the radio buttons
      radioGroup = new ButtonGroup();
      radioGroup.add( radio1 );
      radioGroup.add( radio2 );
      radioGroup.add( radio3 );

      // build left center
      panel8 = new JPanel();
      panel8.setLayout( new FlowLayout( FlowLayout.CENTER, 30, 0 ) );
      panel8.setBackground( Color.white );
      panel8.add( panel4 );
      panel8.add( panel5 );

      // setup left panel
      panel6 = new JPanel();
      panel6.setLayout( new BorderLayout() );
      panel6.add( panel1, BorderLayout.NORTH );
      panel6.add( panel8, BorderLayout.CENTER );
      panel6.add( panel3, BorderLayout.SOUTH );

      // setup applet layout
      panel7 = new JPanel();
      panel7.setLayout( new FlowLayout( FlowLayout.CENTER, 10, 0 ) );
      panel7.add( panel6 );
      panel7.add( panel2 );
      getContentPane().add( panel7 );

      setSize( 400, 160 );
      setVisible( true );

   } // end constructor

   public static void main( String args[] )
   {
      Printer app = new Printer();
      app.setDefaultCloseOperation( EXIT_ON_CLOSE );
   }

}  // end class Printer
