import java.io.*;
import java.util.Scanner;

public class ReverseApp {
  
  public static void main( String[] args ) {
    String input, output;
    Scanner scanner = new Scanner( System.in );
    
    while( true ) {
      System.out.print( "Enter a string: " );
      System.out.flush();
      input = scanner.next(); // read a string from kbd
      if( input.equals(" ") ) // quit if [Enter]
          break;
      
      Reverser theReverser = new Reverser( input );
      output = theReverser.doRev(); // use it
      System.out.println("Reversed: " + output + "\n" );
      
    }
  }
}
