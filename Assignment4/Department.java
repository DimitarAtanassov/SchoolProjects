// Assignment #: 4
// Arizona State University - CSE205
//        Name: Dimitar Atanassov
//    StudentID: 1217419086
//      Lecture: 4:30 PM - 5:45 PM
// Description: Provides information of a department 
//				at a University. 
public class Department {
	//Instance variables of object
	private String departmentName;	//Stores Name of department
	private int numberOfMembers;	//Stores number of members in department
	private String University;	//Stores university the Department belongs to
	private Faculty currentFaculty;	//Stores the current Faculty of Department
	
	//Constructor
	public Department() {
		this.departmentName = "?";
		this.numberOfMembers = 0;
		this.University = "?";
		this.currentFaculty = new Faculty();
	}
	
	public String getDeptName() {	//Accessor method to get Department name
		return departmentName;
	}
	
	public int getNumberOfMembers() {	//Accessor method to get number of members in department
		return numberOfMembers;
	}
	
	public String getUniversity() {	//Accessor method to get universtiy the Department belongs to
		return University;
	}
	public Faculty getCurrentFaculty() {	//Accessor method to get the current Faculty
		return currentFaculty;
	}

	public void setNumberOfMembers(int numberOfMembers) {	//Mutator method use to set number of members
		this.numberOfMembers = numberOfMembers;
	}
	
	public void setDeptName(String departmentName ) {
		this.departmentName = departmentName;
	}
	
	public void setUniversity(String University) {	//Mutator method use to set University of department
		this.University = University;
	}
	
	public void setCurrentFaculty(String firstName, String lastName, String academicLevel) { //Mutator method use to create faculty
		this.currentFaculty.setFirstName(firstName);
		this.currentFaculty.setLastName(lastName);
		this.currentFaculty.setAcademicLevel(academicLevel);
	}
	
	public String toString() {	//Method to put all information together
		return "\nDepartment Name:\t\t" + getDeptName() + "\nNumber Of Members:\t" + getNumberOfMembers() + "\nUniversity:\t\t" + getUniversity() + "\nFaculty:\t\t" + getCurrentFaculty() + "\n\n";  
	}




	  










}
