import java.util.Scanner;

public class MaximumFinder {
	public static void main( String[] args ) {
		Scanner input = new Scanner( System.in );
		System.out.print( "Enter three floating-point values separated by spaces: " );
		
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		double num3 = input.nextDouble();
		
		double result = maximum( num1, num2, num3 ); 
		System.out.println( "Maximum is " + result );
	}
	
	public static double maximum( double x, double y, double z ) {
		double maxValue = x;
		if( maxValue < y ) { maxValue = y; }
		if( maxValue < z ) { maxValue = z; }
		
		return maxValue;
	}
} 