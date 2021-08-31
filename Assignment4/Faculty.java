// Assignment #: 4
// Arizona State University - CSE205
//        Name: Dimitar Atanassov
//    StudentID: 1217419086
//      Lecture: 4:30 PM - 5:45 PM
// Description: Provides information of faculty who 
//				belong to a department. 
public class Faculty {
	//Instance Variables 
	private String firstName;	//Stores first name
	private String lastName;	//Stores last name
	private String academicLevel;	//Stores academic level
	
	//Constructor
	public Faculty() {
		this.firstName = "?";
		this.lastName = "?;";
		this.academicLevel = "?";
	}

	public String getFirstname() { 	//Accessor method to get first name of object
		return firstName;
	}
	
	public String getLastName() {	//Accessor method to get last name of object
		return lastName;
	}
	
	public String getAcademicLevel() {	//Accessor method to get academic level of object
		return academicLevel;
	}
	
	public void setFirstName(String firstName) { //Method used to set first name (Mutator)
		//this.x refers to the instance variable of the object
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) { //Method used to set last name (Mutator)
		this.lastName = lastName;
	}
	
	public void setAcademicLevel(String academicLevel) { //Method used to set Academic Level
		this.academicLevel = academicLevel;
	}
	
	public String toString() {	//Method used to print the information of the object
		return String.format("%s,%s(%s)",this.lastName, this.firstName, this.academicLevel);
	}



		
}
