package com.driver;

import com.driver.exceptions.AccountNumberGenerationException;
import com.driver.exceptions.InsufficientBalanceException;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {

    	this.name=name;
    	this.balance=balance;
    	this.minBalance=minBalance;

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
    	
    	if(digits<=0) {
    		 throw new AccountNumberGenerationException("Number of digits should be greater than 0.");
    	}
    	StringBuilder accountNumber= new StringBuilder();
    	for(int i=0;i<digits-1;i++) {
    		int digit=(int)(Math.random()*10);
    		accountNumber.append(digit);
    		sum-=digit;
    	}
    	 if (sum < 0 || sum > 9) {
             throw new AccountNumberGenerationException("Account Number can not be generated with the given sum.");
         }
    	 accountNumber.append(sum);

        return accountNumber.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
    	balance = getBalance() + amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
    	
    	if((getBalance()-amount)<minBalance) {
    		 throw new InsufficientBalanceException("Insufficient Balance: Minimum balance requirement not met.");
    	}
    	balance = getBalance() - amount;

    }

	public double getBalance() {
		return balance;
	}

}