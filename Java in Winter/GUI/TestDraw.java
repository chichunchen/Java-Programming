import javax.swing.JFrame;

public class TestDraw {
  
  public static void main( String[] args ) {
    DrawLine panel = new DrawLine();
    JFrame application = new JFrame();
    
    application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    application.add( panel );
    application.setSize( 300, 300 );
    application.setVisible( true ); 
  }
  
}