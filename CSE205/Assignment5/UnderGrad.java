// Assignment #: 5
// Arizona State University - CSE205
//        Name: Dimitar Atanassov
//    StudentID: 1217419086
//      Lecture: 4:30 PM - 5:45 PM
// Description: The UnderGrad class that is a child class of the parent class Student 
//				
import java.text.NumberFormat;
import java.util.Locale;

public class UnderGrad extends Student {
	//Instance variables 
	private boolean inState;
	private int creditUpperbound;
	private double programFee;
	
	public UnderGrad(String firstName, String lastName, String studentID, int numCredit, double rate, boolean inState, double programFee) {	//Constructor for UnderGrad
		super(firstName, lastName, studentID,numCredit,rate);
		this.inState = inState;
		this.programFee = programFee;
		this.tuition = 0.0;
		if (inState == false) {
			this.creditUpperbound = 12;
		}
		else {
			this.creditUpperbound = 7;
		}
	}
	public void computeTuition() {
		if (this.numCredit >= creditUpperbound ) {
			tuition = rate * creditUpperbound + programFee;
		}
		else {
			tuition = rate * numCredit + programFee;
		}
	}
	
	public String toString() {	//Finish this
		Locale usMoney = new Locale("en", "US");
		NumberFormat nf = NumberFormat.getCurrencyInstance(usMoney);
		if (inState == false) {
			return "\nUnderGrad:\nOut-Of-State\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nStudent ID:\t\t" + studentID + "\nCredits:\t\t" + this.numCredit + "\nRate:\t\t\t" + nf.format(rate) + "\nTuition:\t\t" + nf.format(tuition) + "\nStudent Program Fee:\t" + nf.format(programFee) + "\n";
		}
		
		else {
			return "\nUnderGrad:\nIn-State\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nStudent ID:\t\t" + studentID + "\nCredits:\t\t" + this.numCredit + "\nRate:\t\t\t" + nf.format(rate) + "\nTuition:\t\t" + nf.format(tuition) + "\nStudent Program Fee:\t" + nf.format(programFee) + "\n";
		}
		
	}

}
