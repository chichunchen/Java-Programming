import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class LoginFrame extends JFrame {
  
  private JLabel accountLabel;
  private JTextField accountField;
  private JLabel passwordLabel;
  private JPasswordField passwordField;
  private JButton enter;
  
  public LoginFrame() {
    super( "Login Page" );
    setLayout( new FlowLayout() );
    setLocation(500,280);
    
    accountLabel = new JLabel( "Account" );
    add( accountLabel );
    
    accountField = new JTextField( "", 20 );
    add( accountField );
    
    passwordLabel = new JLabel( "Password" );
    add( passwordLabel );
    
    passwordField = new JPasswordField( "", 20 );
    add( passwordField );
    
    enter = new JButton( "Enter" );
    add( enter );
    
    ButtonHandler handler = new ButtonHandler();
    enter.addActionListener( handler );
  }
  
  private class ButtonHandler implements ActionListener {
    public void actionPerformed( ActionEvent event ) {
      
      // must use String to store the getText() value
      String username = accountField.getText();
      String userssn = passwordField.getText();
      
      // compare name and ssn
      if( ( username.equals( "test" ) ) && ( userssn.equals( "1234" ) ) ) {
        
        newframe regFace =new newframe();
        regFace.setVisible(true);
        dispose();
        
      }else JOptionPane.showMessageDialog(null, "Wrong Account Information", "Wrong", JOptionPane.ERROR_MESSAGE); 
    }
  }
}