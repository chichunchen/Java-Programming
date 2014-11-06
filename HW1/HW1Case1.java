import javax.swing.JOptionPane;

public class HW1Case1 {
	public static void main( String[] args ) {
		int num1, num2, num3;
		int sum, average, product, smallest, largest;
		
		num1 = Integer.valueOf( JOptionPane.showInputDialog( "Input first number") ); 
		num2 = Integer.valueOf( JOptionPane.showInputDialog( "Input second number") );
		num3 = Integer.valueOf( JOptionPane.showInputDialog( "Input third number") );

		sum = num1 + num2 + num3;
		average = sum / 3;
		product = num1 * num2 * num3;

		if( num1 < num2 ) {
			if( num1 < num3 ) smallest = num1;
			else smallest = num3;
		} 
		else {
			if( num2 < num3 ) smallest = num2;
			else smallest = num3;
		}

		if( num1 > num2 ) {
			if( num1 > num3 ) largest = num1;
			else largest = num3;
		} 
		else {
			if( num2 > num3 ) largest = num2;
			else largest = num3;
		}

		String result = String.format( "Sum: %d\nAverage: %d\nProduct: %d\nSmallest: %d\nLargest: %d" , sum, average, product, smallest, largest );

		JOptionPane.showMessageDialog( null, result ); 
	} 
}