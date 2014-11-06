public class Account {
	private double balance;
	
	//constructor
	public Account( double initialBalance ) {
		if( initialBalance > 0.0 ) {balance = initialBalance;}
		else balance = 0.0;
	}
	
	public void credit( double amount ) { balance += amount; }
	
	public double getBalance() { return balance; } 
}