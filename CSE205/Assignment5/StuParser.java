// Assignment #: 5
// Arizona State University - CSE205
//        Name: Dimitar Atanassov
//    StudentID: 1217419086
//      Lecture: 4:30 PM - 5:45 PM
// Description: Breaks down user input to create a Student type
//				
public class StuParser {
	
	public static Student parseStringToStudent(String lineToParse) {
		String  initalSplit[] = lineToParse.split("/"); 	//Splits the string wherever a '/' is and makes an array called initalSplit
		if(initalSplit[0].equalsIgnoreCase("Graduate")) {
			String firstName =  initalSplit[1];
			String lastName  = initalSplit [2];
			String studentID = initalSplit [3];
			int numCredit = Integer.parseInt(initalSplit[4]);
			double rate = Double.parseDouble(initalSplit[5]);
			double gradFee = Double.parseDouble(initalSplit[6]);
			Graduate Gradstudent= new Graduate (firstName, lastName, studentID, numCredit, rate, gradFee);
			return Gradstudent;
		}
		else if(initalSplit[0].equalsIgnoreCase("UnderGrad")) {
			String firstName = initalSplit[1];
			String lastName = initalSplit[2];
			String studentID = initalSplit [3];
			int numCredit = Integer.parseInt(initalSplit[4]);
			double rate = Double.parseDouble(initalSplit[5]);
			boolean inState;
			if(initalSplit[6].equalsIgnoreCase("InState")) {
				inState = true;
			}
			else {inState = false;}
			double programFee = Double.parseDouble(initalSplit[7]);
			UnderGrad UnderGradStu = new UnderGrad(firstName ,lastName , studentID ,numCredit, rate ,inState,programFee);
			return UnderGradStu;
		}
		else {return null;}
	}


}
