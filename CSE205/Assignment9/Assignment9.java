
//  Assignment: ASU CSE205 Spring 2021 #9
//  Name: Dimitar Atanassov
//  StudentID: 1217419086
//  Lecture:	4:30/5:45
//  Description: The Assignment 9 class reads a sequence of integers from input,
//  and compute the maximum, counts numbers divisible by 3, sum of numbers larger than the last, and
//  compute the largest even integer in the sequence using recursion.

import java.io.*;

public class Assignment9 {
	public static void main(String[] args) {

		// Declare integers and int array to store information
		int num, even, max, count, sum, i = 0;
		int[] numbers = new int[100];
		int input = 1;
		

		// Try-Catch block for input stream and buffered reader io exceptions
		try {

			// Create an input stream reader and buffered reader object
			InputStreamReader isr = new InputStreamReader(System.in );		
			
			BufferedReader stdin = new BufferedReader(isr);			//Takes user input 
			
			// while or do-While loop to store all integers in the array until 0
   			// read in the number as a string and parse to an integer and assign it to array element
		       // Continue iterating until 0 is entered
			 do{
				input = Integer.parseInt(stdin.readLine());
				numbers[i] = input;
				if(input == 0) {
					break;	//Breaks out if input is 0 (Do not want it added into array)
				}
				i++;
			}while(input != 0);
               



		} //end of try block

		// Catch an IO Exception and print out it occured
		catch(IOException ex) {
			System.out.println("IO Exception");
		}
         
		// Call recursive functions to calculate min, countOdd, largeEven, and sum
		max = findMax(numbers,i, 1);	//Iterates from end of erray to start
		even = largestEven(numbers,0,i - 1);	//Iterates from start of array to end
		count = countDivisibleBy3(numbers,0,i);
		sum = sumLargerThanLast(numbers, 0, i - 1, numbers[i - 1]);
		System.out.println("The maximum number is " + max);
		System.out.println("The largest even integer in the sequence is " + even);
		System.out.println("The count of numbers divisible by 3 is " + count);
		System.out.println("The sum of numbers larger than the last is " + sum);
		// Print out results in required format
		



	}	// End main method

	// Recursive static method to find maximum array value
	public static int findMax(int[] nums, int startIndex, int endIndex) {
		//2,4,6,8,3,9
		//max = 9 this is what we want to find
		//Keep calling until startIndex = endindex;
		//if startIndex = endIndex return max
		//Max var needed
		if(startIndex == endIndex) {
			return nums[0];	//When startIndex is equal to the endIndex that means we iterated through the whole array and we need to now compare so return index 0
		}
		else {
			return Math.max(nums[startIndex - 1], findMax(nums,startIndex - 1, 1));	//Compares the two values and returns the greater one
		}
	}	// End findMax method

	
	
	// Recursive static method to find the largest even number in the array
        public static int largestEven(int[] nums, int startIndex, int endIndex) {
        	//int max;
        	if(startIndex == endIndex) {
        		return nums[startIndex];
        	}
        	else {
        		if(largestEven(nums,startIndex + 1, endIndex) % 2 == 0) {	//If num at startindex + 1 is even
        			if(nums[startIndex]% 2 == 0 && nums[startIndex] > largestEven(nums,startIndex + 1, endIndex)  ) {  //Checks if nums @ startIndex is even and if it is greater than the value right next to it
        				return nums[startIndex];
        			}
        			else {
        				//return max; //Max is greater than start index and it is even
        				return largestEven(nums,startIndex + 1, endIndex);
        			}
        		}
        		else {
        			return nums[startIndex];	// if max is not even return the current startIndex and compare it to the next one
        		}
        	}







	}	// End computeLargestEven method

	public static int countDivisibleBy3(int[] nums, int startIndex, int endIndex)
	{
		if(startIndex < endIndex) {
			if(Math.abs(nums[startIndex]) % 3 == 0) {	//Check if it is odd aka divisble by 3
				return 1 + countDivisibleBy3(nums,startIndex + 1, endIndex);	//add a count of 1 if it is
			}
			else {
				return countDivisibleBy3(nums,startIndex + 1, endIndex);	//If not move onto the next index in your array 
			}
		}
		else {
			return 0;	//Do not need to return anything in this case
		}
	} //end countDivisibleBy3
	  
	
	
	// Recursive static method to find the sum of all numbers larger than the last number in the array
	public static int sumLargerThanLast(int[] nums, int startIndex, int endIndex, int lastNumber) {
		if(startIndex < endIndex) {
			if(nums[startIndex] > lastNumber) {		//Checks if numbers at index are greater than the last num
				return nums[startIndex] + sumLargerThanLast(nums,startIndex + 1, endIndex, lastNumber); //if they are add them together
			}
			else {
				return sumLargerThanLast(nums, startIndex + 1, endIndex, lastNumber);	//Else move onto the next index
			}
		}
		else {
			return 0;
		}




	}	// End sumOfNumbersLargerThanFirst method
}//end Assignment9 class