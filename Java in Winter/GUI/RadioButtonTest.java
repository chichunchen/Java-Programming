import javax.swing.JFrame;

public class RadioButtonTest {
  public static void main( String[] args ) {    
    RadioButtonFrame radioButton = new RadioButtonFrame();
    radioButton.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    radioButton.setSize( 300, 300 );
    radioButton.setVisible( true );
  }
}