// Assignment #: 2
// Arizona State University - CSE205
//        Name: Dimitar Atanassov
//    StudentID: 1217419086
//      Lecture: 4:30 PM - 5:45 PM
// Description: Reads an unspecified number of integers from standard input.
//				Performs some type of calculation on these inputs and outputs the results.
//				Program will read input until the number 0 is entered

import java.util.Scanner; //use the Scanner class from the java.util package

public class Assignment2 {
	
	public static void main (String [] args) {
		
		Scanner in = new Scanner(System.in); //Creates a scanner var in
		
		int MAX = 0; //Used to hold the max int
		int evencount = 0; //Count of even ints
		int MINodd = 0;  //smallest odd int
		int negSum = 0;  //sum of negative ints
		int Zerohold; //Holds zero
		do {
			Zerohold = in.nextInt(); //Takes user input 
			
		
			if(Zerohold > MAX) { //Checks if input is greater than max 
				MAX = Zerohold;  //The input is the new max
			}
			
			if(Zerohold % 2 == 0) { //Checks if input is even
				evencount++; //Adds 1 to the even count
			}
			
			if(Zerohold % 2 != 0) {  //Checks if input is odd
				if(Zerohold < MINodd) { //Checks if the input is smaller than the current min
					MINodd = Zerohold;  // Sets new odd min
				}
			}
			
			if (Zerohold < 0) {
				negSum += Zerohold; //negSum = negSum + Zerohold
			}
			
			//End of Do loop
		}while(Zerohold != 0); //While input does not equal 0 
		
		//Outputs
		System.out.println("The maximum integer is " + MAX); //Prints max
		System.out.println("The count of even integers in the sequence is " + evencount); //Prints even count
		System.out.println("The smallest odd integer in the sequence is " + MINodd); //Prints smallest odd
		System.out.println("The sum of negative integers is " + negSum); //Prints negative sum
		
		
	}
	

}
