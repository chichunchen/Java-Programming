import java.util.Scanner;

public class HW2_1 {
	
	private static int radius;
	private static double diameter;
	private static double circumference;
	private static double area;

	public static void main( String[] args ) {

		Scanner input = new Scanner( System.in );

		System.out.println( "Input radius in Integer: " );
		radius = input.nextInt();

		computeRadius( radius );
		computeResult();

	}

	private static void computeRadius( int radius ) {
		diameter = 2 * radius;
		circumference = 2 * Math.PI * radius;
		area = Math.PI * radius * radius;
	}

	private static void computeResult() {
		System.out.printf( "Diameter: %f\nCircumference: %f\nArea: %f\n", diameter, circumference, area );
	}

}