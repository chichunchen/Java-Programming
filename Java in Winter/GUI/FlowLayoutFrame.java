import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class FlowLayoutFrame extends JFrame {
  private JButton leftJButton;
  private JButton rightJButton;
  private JButton centerJButton;
  private FlowLayout layout;
  private Container container;
  
  public FlowLayoutFrame() {
    super( "FlowLayout Demo" );
    
    layout = new FlowLayout();
    container = getContentPane();     //getContentPane(): Returns the contentPane object for this frame
    setLayout( layout );
    
    leftJButton = new JButton( "Left" );
    add( leftJButton );
    leftJButton.addActionListener (
    
    new ActionListener() {
      
      public void actionPerformed( ActionEvent event ) {
        layout.setAlignment( FlowLayout.LEFT );
        layout.layoutContainer( container );
      }
      
    }
    
    );
    
    centerJButton = new JButton( "center" );
    add( centerJButton );
    centerJButton.addActionListener (
    
    new ActionListener() {
      
      public void actionPerformed( ActionEvent event ) {
        layout.setAlignment( FlowLayout.CENTER );
        layout.layoutContainer( container );
      }
      
    }
    
    );
    
    rightJButton = new JButton( "right" );
    add( rightJButton );
    rightJButton.addActionListener (
    
    new ActionListener() {
      
      public void actionPerformed( ActionEvent event ) {
        layout.setAlignment( FlowLayout.RIGHT );
        layout.layoutContainer( container );
      }
      
    }
    
    );  
  }
}