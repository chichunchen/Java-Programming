package pack.Shapes;

import java.awt.Graphics;

public class MyLine extends MyShape {
  
  public MyLine() {
    super();
  }
  
  public MyLine( int x1, int y1, int x2, int y2, int a, int b, int c ) {
    super( x1, y1, x2, y2, a, b, c );
  }
  
  @Override
  public void draw( Graphics g ) {
    g.setColor( super.getColor() );
    g.drawLine( super.getX1Value(), super.getY1Value(),super.getX2Value() , super.getY2Value() );
  } 
}