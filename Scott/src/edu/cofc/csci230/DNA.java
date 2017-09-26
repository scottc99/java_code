package edu.cofc.csci230;
import java.util.Scanner;

public class DNA {

	public static void main(String args[]) 
	{
		
// Set up scanner to get DNA strands from user
		
		Scanner scan = new Scanner(System.in); 

		System.out.print("Enter upper DNA strand: ");
		String upperStr = scan.nextLine();
		upperStr = upperStr.toUpperCase();
		int upperLength = upperStr.length();

		System.out.print("Enter lower DNA strand: ");
		String lowerStr = scan.nextLine();
		lowerStr = lowerStr.toUpperCase();
		int lowerLength = lowerStr.length();
		
		scan.close();
		System.out.print("\n");

// Check user input to see if upper strand or lower strand is empty
		
		if(upperStr.isEmpty() || lowerStr.isEmpty())	{
			System.out.print("The entered upper strand or lower strand is not defined ");
			System.out.print("... Exiting program");
			return;
		}

// Check user input to see if upper strand or lower strand contain the same number of letters
		
		if(upperLength != lowerLength) {
			System.out.print("The entered lower and upper strands do not have the same ");
			System.out.print("number of chemical bases ... Exiting program");
			return;
		}

		for(int x=0; x<upperLength; x++) {
			char chemUp = upperStr.charAt(x);
			char chemLow = lowerStr.charAt(x);

// Check user input to see that the letters used are A, G, C, or T in both the upper and lower strands
			
			if(chemUp!='A' && chemUp!='T' && chemUp!='G' && chemUp!='C') {
				System.out.println("The entered upper and lower strands must only contain ");
				System.out.println("combinations of A, G, C, or T ... Exiting program");
				System.exit(0);
			}
			else if(chemLow!='A' && chemLow!='T' && chemLow!='G' && chemLow!='C') {
				System.out.println("The entered upper and lower strands must only contain ");
				System.out.println("combinations of A, G, C, or T ... Exiting program");
				System.exit(0);
			}
			else {
				continue;
			}
		}
		
// Convert both input strings to char arrays
		
		char upArr[] = upperStr.toCharArray();
		char lowArr[] = lowerStr.toCharArray();

		boolean change = false;

// Replace letter in lower strand if it is not the correct letter
// Check each char in char array for a mismatch and replace with appropriate letter in lower-case
		
		for(int x=0; x<upperLength; x++) {
			char chemUp = upperStr.charAt(x);
			char chemLow = lowerStr.charAt(x);

			if(chemUp=='A' && chemLow!='T') {
				lowArr[x]='t';
				change = true;
			}
			else if(chemUp=='T' && chemLow!='A') {
				lowArr[x]='a';
				change = true;

			}
			else if(chemUp=='G' && chemLow!='C') {
				lowArr[x]='c';
				change = true;
			}
			else if(chemUp=='C' && chemLow!='G') {
				lowArr[x]='g';
				change = true;
			}
			else{
				//Add the correct letter 
				lowArr[x]=chemLow;
			}
		}

// If there are changes made to the char array, print out message stating these changes
// Otherwise, the DNA strands match and are correct
		
		if(change==true) {
			System.out.print("The entered double-strand DNA pattern had base-pair errors that have been corrected: " + new String(upArr));
			System.out.print(" " + new String(lowArr) + "\n");
			System.out.print("\n... Exiting program");

		}	
		else {
			System.out.print("The entered double-strand DNA pattern is correct ... Exiting program");
		}

	}
}
