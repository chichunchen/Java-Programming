import com.deitel.ch08.Time1;

public class Time1PackageTest {

	public static void main( String[] args ) {
		Time1 time = new Time1();
		time.setTime( 13, 27, 6 );
		System.out.println( time.toUniversalString() );
		System.out.println( time );
	}
}