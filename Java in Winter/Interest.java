public class Interest {
	public static void main( String[] args ) {
		double amount;
		double principle = 1000.0;
		double rate = 0.05;
		
		System.out.printf( "%s%20s\n", "Year", "Amount of deposit" );
		
		for( int i = 1; i <= 10; i++ ) {
			amount = principle * Math.pow( 1.0 + rate , i ); 
			
			System.out.printf( "%4d%,20.2f\n", i, amount );
		}
	}
}