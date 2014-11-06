class StackY {
  private int maxSize;
  private char[] stackArray;
  private int top;
  
  public StackY( int max ) {
    maxSize = max;
    stackArray = new char[ maxSize ];
    top = -1;
  }
  
  public void push( char j ) {
    stackArray[ ++top ] = j;
  }
  
  public char pop() {
    return stackArray[ top-- ];
  }
  
  public char peek() {      //peet at top of stack
    return stackArray[ top ];
  }
  
  public boolean isEmpty() {
    return ( top == -1 );
  }
  
  public boolean isFull() {
    return ( top == maxSize - 1 );
  }
}
