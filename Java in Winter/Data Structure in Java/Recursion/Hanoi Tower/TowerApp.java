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
      doTowers( topN - 1, from, to, inter );    //�Ѩӷ���β��컲�U���
      System.out.println( "Disk " + topN + " from " + from + " to " + to );   //�Ѩӷ���β��ܥت��a���
      doTowers( topN - 1, inter, from, to );    //�Nn-1�ӽL�l�q���U��β���ت��a���
    } 
    
  }
  // end methods
}