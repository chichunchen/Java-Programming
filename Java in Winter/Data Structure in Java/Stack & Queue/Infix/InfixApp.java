import java.util.Scanner;

public class InfixApp {
  public static void main(String[] args) {
    String input, output;
    Scanner scanner = new Scanner( System.in );
    while( true )
    {
      System.out.print("Enter infix: ");
      System.out.flush();
      input = scanner.next(); // read a string from kbd
      if( input.equals(" ") ) // quit if [Enter]
          break;
      
      InToPost theTrans = new InToPost( input );
      output = theTrans.doTrans(); // do the translation
      System.out.println( "Postfix is " + output + '\n' );
    } 
  } 
}
