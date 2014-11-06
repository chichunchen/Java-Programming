import javax.swing.JOptionPane;

public class HW1Case2 {
	public static void main( String[] args ) {
		int num1, num2, num3;
		int sum, average, product, smallest, largest;
		
		num1 = Integer.valueOf( JOptionPane.showInputDialog( "Input first number") ); 
		num2 = Integer.valueOf( JOptionPane.showInputDialog( "Input second number") );
		num3 = Integer.valueOf( JOptionPane.showInputDialog( "Input third number") );
		
		sum = num1 + num2 + num3;
		average = sum / 3;
		product = num1 * num2 * num3;
		smallest = small( num1, num2, num3 );
		largest = large( num1, num2, num3 );

		String result = String.format( "Sum: %d\nAverage: %d\nProduct: %d\nSmallest: %d\nLargest: %d" , sum, average, product, smallest, largest );

		JOptionPane.showMessageDialog( null, result ); 
		
	} 

	public static int small( int n1, int n2, int n3 ) {
		if( n1 < n2 ) {
			if( n1 < n3 ) return n1;
			else return n3;
		} 
		else {
			if( n2 < n3 ) return n2;
			else return n3;
		}
	}

	public static int large( int n1, int n2, int n3 ) {
		if( n1 > n2 ) {
			if( n1 > n3 ) return n1;
			else return n3;
		} 
		else {
			if( n2 > n3 ) return n2;
			else return n3;
		}
	}
}