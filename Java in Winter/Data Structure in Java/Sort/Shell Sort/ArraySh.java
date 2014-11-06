public class ArraySh {
  private long[] theArray;
  private int nElems;
  
  public ArraySh( int max ) {
    theArray = new long[ max ];
    nElems = 0;
  }
  
  public void insert( long value ) {
    theArray[ nElems++ ] = value;
  }
  
  public void display() {
    System.out.print( "A = " );
    for(int j=0; j<nElems; j++) // for each element,
    System.out.print( theArray[j] + " " ); // display it
    System.out.println( " " );
  }
  
  public void shellSort() {
    int inner, outer;
    long temp;
    
    int h = 1;
    while( h <= nElems / 3 ) h = ( h * 3 + 1 );
  }
}