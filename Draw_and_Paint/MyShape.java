package pack.Shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape {
  private int x1;
  private int y1;
  private int x2;
  private int y2;
  private Color color;
  
  //no argument constructor
  public MyShape() {
    setX1Value( 0 );
    setY1Value( 0 );
    setX2Value( 0 );
    setY2Value( 0 );
    color = new Color( 0, 0, 0 );
  }
  
  public MyShape( int x1, int y1, int x2, int y2, int a, int b, int c ) {
    setX1Value( x1 );
    setY1Value( y1 );
    setX2Value( x2 );
    setY2Value( y2 );
    setColor( a, b, c );
  }
  
  public void setX1Value( int x1 ){
    this.x1 = x1;
  }
  
  public int getX1Value() {
    return x1;
  }
  
  public void setY1Value( int y1 ){
    this.y1 = y1;
  }
  
  public int getY1Value() {
    return y1;
  }
  
  public void setX2Value( int x2 ){
    this.x2 = x2;
  }
  
  public int getX2Value() {
    return x2;
  }
  
  public void setY2Value( int y2 ){
    this.y2 = y2;
  }
  
  public int getY2Value() {
    return y2;
  }
  
  public void setColor( int a, int b, int c ) {
    color = new Color( a, b, c);
  }
  
  public Color getColor() {
    return color;
  }
  
  public abstract void draw( Graphics g );
  
}