import java.io.*;

public class StackTriangleApp {
  static int theNumber;
  static int theAnswer;
  static StackX theStack;
  static int codePart;
  static Params theseParams;
  
  public static void main( String[] args ) throws IOException {
    System.out.print( "Enter a number: " );
    theNumber = getInt();
    recTriangle();
    System.out.println( "Triangle = " + theAnswer );
  }
  public static void recTriangle() {
    
  }
  
  public static boolean step() {
    
  } 
  
  public static String getString() throws IOException 
  {
    InputStreamReader isr = new InputStreamReader( System.in );
    BufferedReader br = new BufferedReader( isr );
    String s = br.readLine();
    return s;
  }
  
  public static int getInt() throws IOException
  {
    String s = getString();
    return Integer.parseInt( s );
  }
}