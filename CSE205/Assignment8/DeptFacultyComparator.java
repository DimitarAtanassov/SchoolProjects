//Assignment: ASU CSE205 Spring 2021 #8
//Name: Dimitar Atanassov
//StudentID: 1217419086
//Lecture: 4:30 - 5:45 
//Description: Compares the department faculty first name and last name

import java.util.Comparator;

public class DeptFacultyComparator implements Comparator<Department>
{
	//First we compare the currentFaculty's last name, if they are same, we then compare
	//their first names. The departments should be listed in the alphabetical order of the
	//currentFaculty's last and first names
	public int compare(Department first, Department second)
	{
		//----
		Department dep1 = first;	//Stores department obj in a var (this is for readability)
		Department dep2 = second;
		
		int result = 0;			//Varible that will be returned for the comparison
		if(dep1.getFaculty().getLastName().compareTo(dep2.getFaculty().getLastName()) == 0) {	//Checks if dep1 and dep2 lastname are equal
			if(first.getFaculty().getFirstName().compareTo(second.getFaculty().getFirstName()) < 0) {	//If they are comapre firstnames
				result = -1;	//If dep1 is less than dep2 result is -1
			}
			else if(first.getFaculty().getFirstName().compareTo(second.getFaculty().getFirstName()) > 0) {
				result = 1;		//If dep1 is more than dep2 result is 1
			}
			
		}
		else {	//If last names dont match
			if(first.getFaculty().getLastName().compareTo(second.getFaculty().getLastName()) < 0) {
				result = -1;
			}
			else if(first.getFaculty().getLastName().compareTo(second.getFaculty().getLastName()) > 0) {
				result = 1;
			}
		}
		return result;
		
	}
}
