import java.util.*;

public class HW2_4 {

	static final int maxn = 10000 + 10;
	int[] a, b, c;
	
	public HW2_4() {
		a = new int[ maxn ];
		b = new int[ maxn ];
		c = new int[ maxn ];
		
		Scanner input = new Scanner( System.in );
		
		//T is the time loops run
		int T = input.nextInt();
		
		while( T > 0 ) {
			//n is how many array
			int n = input.nextInt();
			
			for(int i = 0; i < n; i++) {
				a[ i ] = input.nextInt();
				b[ i ] = input.nextInt();
				c[ i ] = input.nextInt();
			}
			
			//System.out.println( F(1, n) );
			
			double L = 0.0, R = 1000.0;
    
			for(int i = 0; i < 100; i++) {
				double m1 = L + ( R - L ) / 3;
				double m2 = R - ( R - L ) / 3;
				if( F( m1, n ) < F( m2, n ) ) R = m2; 
				else L = m1;
			}
			
			System.out.printf( "\nThe Max is %.4f\n", F( L, n ) );	
		}	
	}

	public double F( double x, int size ) {
		double max = a[0] * x * x + b[0] * x + c[0];
		
		for( int i = 1; i < size; i++ ) {
			if( max < a[i] * x * x + b[i] * x + c[i] )
				max = a[i] * x * x + b[i] * x + c[i];
		}
		
		return max;
	}

	public static void main( String[] args ) {
		new HW2_4();
	}
}