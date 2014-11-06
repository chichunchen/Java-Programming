package pack.Product;

import javax.swing.JFrame;

public class PictureDemo {
  public static void main( String[] args ) {
    
    MenuFrame menuFrame = new MenuFrame();
    menuFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    menuFrame.setSize( 500, 500 );
    menuFrame.setVisible( true );
  }
}