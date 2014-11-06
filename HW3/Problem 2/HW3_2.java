public class HW3_2 {
	
	private static double[] x = { -1, -1, 1, 2, 2, 3, 4, 4 };
	private static double[] y = { 3, -1, 1, 0.5, -1, 3, 2, -0.5 };
	
	private static void computeDistance() {
		double ans = Math.pow( x[1] - x[0], 2 ) + Math.pow( y[1] - y[0], 2 );		
		int left=0, right=0;
		
		for( int i = 1; i < x.length; i++ ) {
			for( int j = i + 1; j < x.length; j++ ) {
				if( ans > Math.pow( x[j]-x[i], 2 ) + Math.pow( y[j]-y[i], 2 ) ) {
					ans = Math.pow( x[j]-x[i], 2 ) + Math.pow( y[j]-y[i], 2 );
					left = i; right = j;
				}
			}
		}
		System.out.printf( "The shortest two point is (%.4f,%.4f) and (%.4f,%.4f)\n", x[left], y[left], x[right], y[right] );
		System.out.printf( "Distance: %.4f", Math.sqrt( ans ) );  
	}
	
	public static void main( String[] args ) {
		computeDistance();
	}
}