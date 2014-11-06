import java.util.Random;
import java.util.ArrayList;

public class quick_find_2d_peak {

	private int[][] A;

	public quick_find_2d_peak() {
		randomInput();
		print();

		int result = peak2d( A, 0, A.length - 1, 0, A.length - 1 );
		System.out.println(result);
	}

	public void randomInput() {
		Random random = new Random();
		int side = 9;
		//int side = random.nextInt( 18 ) + 2;

		A = new int[ side ][ side ];

		for( int i = 1; i < A.length - 1; i++ ) {
			for( int j = 1; j < A.length - 1; j++ ) {
				if( i == 0 || j == 0 ) 
					A[ i ][ j ] = 0;
				else
					A[ i ][ j ] = random.nextInt( 99 ) + 1;
			}
		}
	}

	public void print() {
		for( int i = 0; i < A.length; i++ ) {
			for( int j = 0; j < A.length; j++ ) {
				System.out.printf( "%3d", A[ i ][ j ] );
			}
			System.out.println();
		}
		System.out.println();
	}

	public int peak2d( int[][] A, int xtop, int xlast, int ytop, int ylast ) {
		int mx = ( xtop + xlast ) / 2;
		int my = ( ytop + ylast ) / 2;
		int largest = 0, colIndex = -1, rowIndex = -1;		//x, y

		for( int i = 0; i < A.length; i++ ) {
			if( A[ my ][ i ] >= largest ) {
				largest = A[ my ][ i ];
				rowIndex = my;
				colIndex = i;
			}
		}
		for( int j = 0; j < A.length; j++ ) {
			if( A[ j ][ mx ] >= largest ) {
				largest = A[ j ][ mx ];
				rowIndex = j;
				colIndex = mx;
			} 
		}
		System.out.printf( "A[%d][%d] = %d\n", colIndex, rowIndex, largest );
		
		//up, right, down, left
		if( A[colIndex][rowIndex] > A[colIndex][rowIndex-1] && A[colIndex][rowIndex] > A[colIndex+1][rowIndex] && A[colIndex][rowIndex] > A[colIndex][rowIndex+1] && A[colIndex][rowIndex] > A[colIndex-1][rowIndex] ) {
			return A[colIndex][rowIndex];
		}
		//up be the largest 
		else if( A[colIndex][rowIndex-1] >= A[colIndex+1][rowIndex] && A[colIndex][rowIndex-1] >= A[colIndex-1][rowIndex] && A[colIndex][rowIndex-1] >= A[colIndex-1][rowIndex] ) {
			if( colIndex > mx ) return peak2d( A, mx, xlast, 0, my );
			else return peak2d( A, 0, mx, 0, my );
		}
		//right be the largest
		else if( A[colIndex+1][rowIndex] >= A[colIndex][rowIndex-1] && A[colIndex+1][rowIndex] >= A[colIndex][rowIndex+1] && A[colIndex+1][rowIndex] >= A[colIndex-1][rowIndex]) {
			if( rowIndex > my ) return peak2d( A, mx, xlast, 0, my );
			else return peak2d( A, mx, xlast, my, ylast );
		}
		//down be the largest
		else if( A[colIndex][rowIndex+1] >= A[colIndex][rowIndex-1] && A[colIndex][rowIndex+1] >= A[colIndex+1][rowIndex] && A[colIndex][rowIndex+1] >= A[colIndex-1][rowIndex] ) {
			if( colIndex > mx ) return peak2d( A, mx, xlast, my, ylast );
			else return peak2d( A, 0, mx, my, ylast);
		}
		//left be the largest
		else if( A[colIndex-1][rowIndex] >= A[colIndex][rowIndex-1] && A[colIndex-1][rowIndex] >= A[colIndex+1][rowIndex] && A[colIndex-1][rowIndex] >= A[colIndex][rowIndex+1] ) {
			if( rowIndex > my ) return peak2d( A, 0, mx, my, ylast );
			else return peak2d( A, 0, mx, 0, my);
		}
		else return -1;
	}

	public static void main( String[] args ) {
		new quick_find_2d_peak();
	}
}