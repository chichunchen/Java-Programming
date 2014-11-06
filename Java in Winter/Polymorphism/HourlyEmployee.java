public class HourlyEmployee extends Employee {
  private double wage;
  private double hours;
  
  public HourlyEmployee( String first, String last, String ssn, double w, double h ) { 
    super( first, last, ssn );
    setWage( w );
    setHours( h );
  }
  
  public void setWage( double w ) {
    if( w >= 0.0 ) wage = w;
    else {
      throw new IllegalArgumentException( "Hourly wage must be >= 0.0" );
    } 
  }
  
  public double getWage() {
    return wage;
  }
  
  public void setHours( double h ) {
    if( ( h >= 0.0 ) && ( h <= 168.0 ) ) hours = h;
    else {
      throw new IllegalArgumentException( "Hours worked must be >= 0.0 and <= 168.0" );
    }
  }
  
  public double getHours() {
    return hours;
  }
  
  @Override
  public double earnings(){
    if( getHours() <= 40 ) 
    return getWage() * getHours();
    else {
      return 40 * getWage() + ( getHours() - 40 ) * getWage() * 1.5;
    } 
  }
  
  @Override
  public String toString() {
    return String.format( "hourly employee: %s\n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked", getHours() );
  }     
}