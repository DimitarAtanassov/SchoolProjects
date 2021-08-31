// Assignment #: 5
// Arizona State University - CSE205
//        Name: Dimitar Atanassov
//    StudentID: 1217419086
//      Lecture: 4:30 PM - 5:45 PM
// Description: The graduate class that is a child class of the parent class Student 
//				
import java.text.NumberFormat;
import java.util.Locale;

public class Graduate extends Student {
	//Instance variables 
	private double gradFee;
	
	public Graduate (String firstName, String lastName, String studentID, int numCredit, double rate, double gradFee) { //Constructor that uses variable from Student the parent class
		super(firstName, lastName, studentID,numCredit,rate);	//The variables do not need to match the parameter names of the parent class but you need to have to same amount of data types in your parameter as the constructor parent class
		this.gradFee = gradFee;
		this.tuition = 0.0;
	}
	
	public void computeTuition() {	//Method used to compute Tuition for Graduate Students
		this.tuition = rate * numCredit + gradFee;
	}
	
	public String toString() {
		Locale usMoney = new Locale("en", "US");
		NumberFormat nf = NumberFormat.getCurrencyInstance(usMoney);
		return "\nGraduate Student:\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName  + "\nStudent ID:\t\t" + studentID + "\nCredits:\t\t" + numCredit + "\nRate:\t\t\t" + nf.format(rate) + "\nTuition:\t\t" + nf.format(tuition) + "\nGrad Fee:\t\t" + nf.format(gradFee) + "\n";
	}



}
