
public class SavingsAccount extends BankAccount {
	
	private static double rate = 2.5;
	
	private static int savingsNumber = 0;
	
	private static String accountNumber;
	
	public SavingsAccount(String name, double amount)
	{
		super(name, amount);
	}
	
	public SavingsAccount(SavingsAccount oldAccount, double amount)
	{
		super(oldAccount, amount);
		
		savingsNumber += 1;
	}
	
	public void postInterest()
	{
		rate = (rate/100.0)/12;
		
		setBalance((getBalance()*rate) + getBalance());
	}
	
	public String getAccountNumber()
	{
		//savingsNumber += 1;
		
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		
		return accountNumber;
	}

}
