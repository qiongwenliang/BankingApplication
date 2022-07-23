import java.util.Scanner;

public class Accounts {
	
	//Make clear of class variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	//Create class constructors
	Accounts(String cname, String cid){
		customerName = cname;
		customerID = cid;
	}
	
	//Method of depositing money
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	//Method of withdrawing money
	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	//Method of demonstrating previous transaction
	void demonstratePreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		}else if (previousTransaction < 0) {
			System.out.println("Withdrew: " + Math.abs(previousTransaction));
		}else {
			System.out.println("No transaction occurred");
		}
	}
	
	//Method of calculating interests of current funds after a number of years
	void interestCaculation(int years) {
		double interestRate = 0.165;
		double newBalance = (balance + balance*interestRate*years);
		System.out.println("After " + years + " years, your balance will be: " + newBalance);
	}
	
	//Method showing main bank account menu
	void menu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("Which service are you looking for?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdraw");
		System.out.println("D. View previous transactions");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Please enter an option: ");
			char option1 = scanner.next().charAt(0); 
			option = Character.toUpperCase(option1);
			//whatever being typed, it's only going to take the first letter
			System.out.println();
			
			switch(option) {
			case 'A':
				System.out.println("===================================");
				System.out.println("Balance = $" + balance);
				System.out.println("===================================");
				System.out.println();
				break;
			case 'B':
				System.out.println("Please enter the amount to deposit: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
			case 'C':
				System.out.println("Please enter the amount to withdraw: ");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			case 'D':
				System.out.println("===================================");
				demonstratePreviousTransaction();
				System.out.println("===================================");
				System.out.println();
				break;
			case 'E':
				System.out.println("Please enter how many years of accrued interest: ");
				int year = scanner.nextInt();
				interestCaculation(year);
				break;
			case 'F':
				System.out.println("Hope you enjoyed our service!");
				break;
			default:
				System.out.println("Error: invalid option. Please enter A, B, C, D, E or F");
				break;
			}			
		 }while (option != 'F');
		System.out.println("Thank you for banking with us!");
	}
}


