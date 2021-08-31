// Assignment #: 5
// Arizona State University - CSE205
//        Name: Dimitar Atanassov
//    StudentID: 1217419086
//      Lecture: 4:30 PM - 5:45 PM
// Description: The parent class
//				
import java.text.NumberFormat;
import java.util.Locale;
public abstract class Student {	//Creates an abstract class Student
	//Instance variables that are protected so child classes can access them
	protected String firstName;	//Stores firstName
	protected String lastName;	//Stores lastName
	protected String studentID;	//Stores studentID
	protected int numCredit;	//Stores numCredit
	protected double rate;	//Stores rate
	protected double tuition;	//Stores tuition
	
	//Constructor
	public Student(String firstName, String lastName, String studentID, int numCredit, double rate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.numCredit = numCredit;
		this.rate = rate;
		tuition = 0.0;
	}
	
	public int getNumCredit() {	//Accessor method used to get the number of credits of a student
		return this.numCredit;
	}
	
	//Abstract method that can be accessed by child class to update their tuition
	public abstract void computeTuition();	
	
	public String toString() {
		Locale usMoney = new Locale("en", "US");
		NumberFormat nf = NumberFormat.getCurrencyInstance(usMoney);	//Format the doubles
		return "\nFirst name:\t\t" + firstName + "\nLast Name:\t\t" + lastName + "\nStudent ID:\t\t" + studentID + "\nCredits:\t\t" + numCredit + "\nRate:\t\t" + nf.format(rate) + "\nTuition:\t\t" + nf.format(tuition) + "\n";
	}
}
