import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class BMI extends JApplet {
	
	private double bmi;

	public void init() {
		double height = Double.parseDouble( JOptionPane.showInputDialog( "Enter your height ( meter ): " ) );
		double weight = Double.parseDouble( JOptionPane.showInputDialog( "Enter your weight (Kg): " ) );

		bmi = BMIvalue( height, weight );
	}

	public void paint( Graphics g ) {
		super.paint( g );

		g.drawRect( 15, 10, 270, 20 );

		String result = BMIResult( bmi );
		String message = String.format( "Your BMI is: %,2.2f  ,It's %s", bmi, result ); 
		
		g.drawString( message, 25, 25 );
	}

	public static double BMIvalue( double h, double w ) {
		return w / ( h * h );
	}
	
	public static String BMIResult( double b ) {
		if( b < 18.5 ) 
			return "Underweight";
		else if( b > 18.5 && b < 24.9 ) 
			return "Normal";
		else if( b > 25 && b < 29.9 )
			return "Overweight";
		else  
			return "Obese";
	}
	

}