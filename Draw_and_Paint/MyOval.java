package pack.Shapes;

import java.awt.Graphics;

public class MyOval extends MyShape { 
  
  private boolean fill;
  
  public MyOval() {
    super();
    this.fill = false;
  }
  
  public MyOval( int x1, int y1, int x2, int y2, int a, int b, int c, boolean fill ) {
    if( x1 < x2 ) {
      super.setX1Value( x1 );
      super.setX2Value( x2 );
    }else {
      super.setX1Value( x2 );
      super.setX2Value( x1 );
    }
    if( y1 < y2 ) {
      super.setY1Value( y1 );
      super.setY2Value( y2 );
    }else {
      super.setY1Value( y2 );
      super.setY2Value( y1 );
    }
    super.setColor( a, b, c );
    this.fill = fill;
  }
  
  @Override
  public void draw( Graphics g ) {
    if( fill ) {
      g.setColor( super.getColor() );
      g.fillOval( super.getX1Value(), super.getY1Value(),super.getX2Value() - super.getX1Value() , super.getY2Value() - super.getY1Value() );
    }else 
          g.drawOval( super.getX1Value(), super.getY1Value(),super.getX2Value() - super.getX1Value() , super.getY2Value() - super.getY1Value() );
    
  }
}