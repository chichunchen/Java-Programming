public class TowerApp {
  // start attributes
  static int nDisks = 3;
  // end attributes
  
  // start methods
  public static void main( String[] args ) {
    doTowers( nDisks,  'A', 'B', 'C' );
  }
  
  public static void doTowers( int topN, char from, char inter, char to ) {
    if( topN == 1 ) 
    System.out.println( "Disk 1 from " + from + " to " + to );
    else {
      doTowers( topN - 1, from, to, inter );    //パㄓ方れ次簿徊れ次
      System.out.println( "Disk " + topN + " from " + from + " to " + to );   //パㄓ方れ次簿ヘれ次
      doTowers( topN - 1, inter, from, to );    //盢n-1絃眖徊れ次簿ヘれ次
    } 
    
  }
  // end methods
}