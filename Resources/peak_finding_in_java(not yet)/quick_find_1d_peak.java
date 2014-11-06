import java.util.Random;
import java.util.ArrayList;

public class quick_find_1d_peak {
	
	private ArrayList<Integer> A;
	
	public quick_find_1d_peak() {

		A = new ArrayList<Integer>();
		//set random arraylist
		randomInput();

		printArray();
		
		int peakIndex = peak1d( A, 0, A.size() - 1 );
		if( peakIndex == -1 )
			System.out.println( "error!" );
		else 
			System.out.printf( "Peak: A[%d]= %d\n\n", peakIndex, A.get( peakIndex ) );
	}
	
	public void randomInput() {
		Random random = new Random();
		
		int size = random.nextInt( 20 );
		
		//give random numbers to arraylist A
		for( int i = size; i > 0; i-- ) {
			int temp = random.nextInt( 100 );
			A.add( temp ); 
		}
	}
	
	public void printArray() {
		for( int arr : A ) {
			System.out.print( arr + " " );
		}
		System.out.println();
	}
	
	public int peak1d( ArrayList<Integer> A, int i, int j ) {
		int m = ( i + j ) / 2;
		
		if( A.get( m - 1 ) <= A.get( m ) && A.get( m ) >= A.get( m + 1 ) ) 
			return m;
		else if( A.get( m - 1 ) > A.get( m ) )
			return peak1d( A, i, m - 1 );
		else if( A.get( m + 1 ) > A.get( m ) )
			return peak1d( A, m + 1, j );
		else return -1;
	}
	

	public static void main( String[] args ) {
		new quick_find_1d_peak();
	}
}