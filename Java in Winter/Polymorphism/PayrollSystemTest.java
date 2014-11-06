public class PayrollSystemTest {
  public static void main( String[] args ){
    
    SalariedEmployee salariedEmployee = new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
    HourlyEmployee hourlyEmployee = new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
    
    Employee[] employees = new Employee[ 2 ]; 
    employees[ 0 ] = salariedEmployee;
    employees[ 1 ] = hourlyEmployee;
    
    for( Employee currentEmployee : employees ) {
      System.out.println( currentEmployee );
      System.out.printf( "earning $%,.2f\n\n", currentEmployee.earnings() );
    }
  }
}