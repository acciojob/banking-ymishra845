package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
    	super(name,balance, 5000);
    	this.tradeLicenseId=tradeLicenseId;

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
    	
    	StringBuilder rearrenged= new StringBuilder(tradeLicenseId);
    	for(int i=0;i<rearrenged.length()-1;i++) {
    		if(rearrenged.charAt(i)==rearrenged.charAt(i+1)) {  // if the adjacent character are equal then swap it with i+2
    			char temp=rearrenged.charAt(i);
    			rearrenged.setCharAt(i, rearrenged.charAt(i+2));   // swapping i and i+2
    			rearrenged.setCharAt(i+2, temp);                   // and at i+2 temp is assigned i.e i 
    		}else {
                throw new Exception("Valid License can not be generated");  // else throw an exception
            }
    	}
    	
    	this.tradeLicenseId=rearrenged.toString();

    }

}
