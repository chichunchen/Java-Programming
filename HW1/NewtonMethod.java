public class NewtonMethod { 
    public static void main(String[] args) { 

        // read in the command-line argument
        double n = Double.parseDouble(args[0]);
        double epsilon = 0.00001;    // relative error tolerance
        double a = n;              // estimate of the square root of c

        // repeatedly apply Newton update step until desired precision is achieved
        while ( Math.abs( a - n / a ) > epsilon * a ) {
            a = ( a + n / a ) / 2.0;
        }

        // print out the estimate of the square root of c
        System.out.println( a );
    }

}