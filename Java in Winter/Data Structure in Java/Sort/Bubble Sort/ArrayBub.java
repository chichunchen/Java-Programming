public class ArrayBub {
  
  private long[] a;
  private int nElems;  //number of data items
  
  public ArrayBub( int max ) {
    a = new long[ max ];
    nElems = 0;
  }
  
  
  public void insert( long value ) {
    a[ nElems ] = value;
    nElems++;
  }
  
  public void display() {
    for( int j = 0; j < nElems; j++ ) {
      System.out.print( a[j] +  " " );
    }
    System.out.println( " " );
  } 
  
  public void bubbleSort() {
    for( int i = ( nElems - 1 ); i > 1; i-- ) {
      for( int j = 0; j < i; j++ )
           if( a[ j + 1 ] < a[ j ] )
               swap( j, j + 1 );
    }
  }
  
  public void insertionSort() {
    int in, out;
    
    for ( out = 1 ; out < nElems  ; out++ ) {
      long temp = a[ out ];
      in = out;
      while ( in > 0 && a[ in - 1 ] >= temp ) { 
        a[ in ] = a[ in - 1 ];    //shift item left
        --in;
      } 
      a[ in ] = temp;     //insert marked item
    } 
  }
  
  public int find ( long searchKey ) {
    return recFind( searchKey, 0, nElems - 1 );
  }
  
  private int recFind( long searchKey, int lowerBound, int upperBound ) {
    int curIn;
    
    curIn = ( lowerBound + upperBound ) / 2;
    if( a[ curIn ] == searchKey )
        return curIn;
    else if( lowerBound > upperBound ) 
        return nElems;  //can't find it
    else {
      if( a[ curIn ] < searchKey )
          return recFind( searchKey, curIn + 1, upperBound );
      else
          return recFind( searchKey, 0, curIn - 1 );
    } 
  }
  
  private void swap( int one, int two ) {
    long temp = a[ one ];
    a[ one ] = a[ two ];
    a[ two ] = temp;
  }
}