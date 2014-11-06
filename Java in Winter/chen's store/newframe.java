import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class newframe extends JFrame {
  
  public static void main(String[] args) {
    newframe frameTabel = new newframe();
  }
  
  private JComboBox kind = new JComboBox();
  private JPanel panel = new JPanel();
  private static final String[] names = { "Food", "Drink", "Daily Necessities", "Book" };
  private JList comodity = new JList();
    private static final String[][] items = { { "apple", "banana" }, { "milk", "apple juice" }, { "brush", "condom" }, { "newspaper", "novel" } };
  private static String[] listkind;
  
  //constructor
  public newframe(){
    super("Welcome to Chen's Store");
    setSize(340,300);
    setLocation(500,280);
    panel.setLayout (null); 
    
    //comboBox 
    kind = new JComboBox( names );
    kind.setMaximumRowCount( 4 );
    
    kind.addItemListener(
    new ItemListener() {
      public void itemStateChanged( ItemEvent event ) {
        if( event.getStateChange() == ItemEvent.SELECTED ) {
          listkind = items [ kind.getSelectedIndex() ];
          comodity = new JList( listkind );
          comodity.setVisibleRowCount( 5 );   
          comodity.setBounds( 100, 60, 140, 60 );
          panel.add( comodity );
        }
      }
    }
    );
    
    kind.setBounds( 100, 10, 140, 20 );
    panel.add( kind );
    
    getContentPane().add(panel);   
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  
}
