package com.driver;

public class Main {
    public static void main(String[] args) {
    	
    	 BankAccount bankAccount = new BankAccount("John Doe", 100000,10000);
         CurrentAccount currentAccount = null;
		try {
			currentAccount = new CurrentAccount("Jane Smith", 6000, "ABC123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         SavingsAccount savingsAccount = new SavingsAccount("Alice Johnson", 2000, 0.03, 500);
         StudentAccount studentAccount = new StudentAccount("Bob Miller", 500, "University of XYZ");

         // Deposit and withdraw operations on BankAccount
         bankAccount.deposit(500);
         try {
             bankAccount.withdraw(800);
         } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
         }

         // Validate trade license ID for CurrentAccount
         try {
             currentAccount.validateLicenseId();
         } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
         }

         // Withdraw and calculate interest for SavingsAccount
         try {
             savingsAccount.withdraw(600);
             double simpleInterest = savingsAccount.getSimpleInterest(2);
             double compoundInterest = savingsAccount.getCompoundInterest(4, 2);

             System.out.println("Simple Interest: $" + simpleInterest);
             System.out.println("Compound Interest: $" + compoundInterest);
         } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
         }

         // Display details of StudentAccount
        
         System.out.println("Institution Name: " + studentAccount.getInstitutionName());

    	 

    }
}