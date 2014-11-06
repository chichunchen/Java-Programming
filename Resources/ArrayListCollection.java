import java.util.ArrayList;

public class ArrayListCollection {
	
	public static void main( String[] args ) {
		
		ArrayList< String > items = new ArrayList< String >();
		
		items.add( "red" );
	}
	
	public static void display( ArrayList<String> items, String header ) {
		System.out.print( header );
		
		for( String item: items )
			System.out.printf( " %s", item );
		
		System.out.println();
	}
}