package pack.DataStructure;

import pack.Shapes.*;

public class StackX {
  private int maxSize;
  private MyShape[] stackArray;
  private int top;
  
  public StackX( int s ) {
    maxSize = s;
    stackArray = new MyShape[ maxSize ];
    top = -1;
  }
  
  public void push( MyShape j ) {
    stackArray[ ++top ] = j;
  }
  
  public MyShape pop() {
    if( top > -1 ) return stackArray[ top-- ];
    else {
      MyLine myLine = new MyLine( 0, 0, 0, 0, 0, 0, 0 );
      return myLine;
    } // end of if-else
  }
  
  public boolean isEmpty() {
    return ( top == -1 );
  }
  
  public boolean isFull() {
    return ( top == maxSize - 1 );
  }
  
  public MyShape peek( int x ) {
    return stackArray[ x ];
  }
  
  public int topValue() {
    return top;
  }
}