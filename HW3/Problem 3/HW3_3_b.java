import java.util.*;
import java.math.BigInteger;

public class HW3_3_b {    
    public static void main(String[] args) {
        long l;
		Scanner input = new Scanner( System.in );
		
		System.out.print( "Number of factorial: " );
		
		while( input.hasNextInt() ) {
			l = input.nextInt();
			BigInteger bi = factorial( l );
			System.out.println( "Value: " + bi );
			System.out.println( "Total digits: " + bi.toString().length() );
		}
    }
    
    /* BigInteger factorial code */
    public static BigInteger factorial(long n) {
        BigInteger f = BigInteger.ONE;                  // long f = 1;
        BigInteger g = BigInteger.valueOf( n );         // int n
        
        while ( g.compareTo( BigInteger.ONE ) == 1 ) {  // while (n > 1) {
            f = f.multiply( g );                        // f *= n;
            g = g.subtract( BigInteger.ONE );           // n--;
        }
        
        return f;
    }
}