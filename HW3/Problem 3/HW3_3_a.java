import java.math.BigDecimal;

public class HW3_3_a {
	
	public static void main( String[] args ) {
		//more than 30 digits number
		BigDecimal n1 = new BigDecimal( "23498710239712390872139071239" );	
		BigDecimal n2 = new BigDecimal( "11234189073417263829187623476" );
		System.out.printf( "n1: %,.2f\nn2: %,.2f\n", n1, n2 );
		System.out.println( "n1 + n2: " + n1.add( n2 ) );
		System.out.println( "n1 - n2: " + n1.subtract( n2 ) );
		
		BigDecimal n3 = new BigDecimal( "12468941498.12" );
		BigDecimal n4 = new BigDecimal( "41282323432.32" );
		BigDecimal n5 = new BigDecimal( "1000" );
		System.out.printf( "n3: %,.2f\nn4: %,.2f\n", n3, n4 );
		System.out.println( "n3 * n4: " + n3.multiply( n4 ) );
		
		System.out.println( "n3 / n5: " + n3.divide( n5 ) );
	}
}