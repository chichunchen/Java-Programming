package pack.Product;

import java.util.Random;
import java.awt.*;
import javax.swing.*;

import pack.DataStructure.StackX;

public class DrawShape extends JPanel {
  
  private StackX shapeStack = new StackX( 100 );
  
  public DrawShape( StackX shapeStack ) {
    setLayout( new FlowLayout() );
    setBackground( Color.WHITE );
    
    this.shapeStack = shapeStack;
    
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    
    for( int i = shapeStack.topValue(); i > 0; i-- )
      shapeStack.peek( i ).draw( g );
  }
}