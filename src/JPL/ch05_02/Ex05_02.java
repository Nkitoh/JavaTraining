package ch05_02;

public class Ex05_02 {

	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount();
		BankAccount myAccount2 = new BankAccount();
		
		
		myAccount.deposit(100);
		myAccount.deposit(300);
		myAccount.withdraw(200);
		myAccount.deposit(10);
		myAccount.deposit(300);
		myAccount.withdraw(200);
		myAccount.deposit(10);
		myAccount.deposit(100);
		myAccount.deposit(300);
		myAccount.withdraw(200);
		myAccount.deposit(10);
		myAccount.deposit(300);
		myAccount.withdraw(200);
		myAccount.deposit(10);
		
		for(myAccount.history().clear_count() ; myAccount.history().getAction() != null; myAccount.history().next())
			System.out.println(myAccount.history().getAction());

	}

}
