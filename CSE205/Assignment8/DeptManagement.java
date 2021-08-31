//Assignment: ASU CSE205 Spring 2021 #8
//Name: Dimitar Atanassov
//StudentID: 1217419086
//Lecture: 4:30 - 5:45
//Description: //This is the main class that will be used in assignment 8 to make it functions

import java.util.ArrayList;
import java.io.Serializable;
//import all other necessary classes

public class DeptManagement implements Serializable
{
	 ArrayList<Department> deptList;

	public DeptManagement() {
		deptList = new ArrayList<Department>();		//initialize  the array
		
		
	}

	public int deptExists(String deptName, String universityName) {
		int found = -1;	//Stores var to be returned
		for(int i = 0; i < deptList.size(); i++) {
			if(deptList.get(i).getDeptName().equals(deptName) && deptList.get(i).getUniversity().equals(universityName)) {
				return found = i;
			}
		}
		return found;
	}
		//Scans through array and checks if faculty w same name and academic level exists
	public int facultyExists(String firstName, String lastName, String academicLevel) {
		int found = -1;	// -1 means not found
		for(int i =0; i < deptList.size(); i++) {
			if(deptList.get(i).getFaculty().getFirstName().equals(firstName) && deptList.get(i).getFaculty().getLastName().equals(lastName)
									&& deptList.get(i).getFaculty().getAcademicLevel().equals(academicLevel)) {
				return found = i;	
			}
		}
		return found;	
	}

	public boolean addDepartment(String deptName, String university, int numOfMembers, String firstName, String lastName, String academicLevel) {
		//----
		boolean added = true;
		for(int i = 0; i < deptList.size();i++) {	//Checks for duplicates
			if(deptList.get(i).getDeptName().equals(deptName) && deptList.get(i).getUniversity().equals(university)) {
				added = false;
			}
		}
		if( added != false ) {	//If no duplicates create dept and add it to list
			Department newDep = new Department(deptName,university,numOfMembers,firstName,lastName,lastName);
			newDep.setDeptName(deptName);
			newDep.setUniversity(university);
			newDep.setNumOfMembers(numOfMembers);
			newDep.setFaculty(firstName, lastName, academicLevel);
			deptList.add(newDep);
			added = true;
		}
		
		

		return added;
	}

	//***will remove all departments with the same name and university
	public boolean removeDepartment(String deptName, String universityName) {
		boolean removed = false;
		for(int i = 0; i < deptList.size(); i++) {
			if(deptList.get(i).getDeptName().equals(deptName) && deptList.get(i).getUniversity().equals(universityName)) {
				deptList.remove(i);
				removed = true;
			}
		}
		return removed;
		
	}

	public void sortByDepartmentName() {
		//----
		DeptNameComparator comp = new DeptNameComparator();
		Sorts.sort(deptList, comp);
	}

	public void sortByFacultyNumbers() {
		FacultyNumberComparator comp = new FacultyNumberComparator();
		Sorts.sort(deptList, comp);
	}

	public void sortByDeptFaculty() {
		DeptFacultyComparator comp = new DeptFacultyComparator();
		Sorts.sort(deptList,comp);
	}

	public String listDepartments() {
		//----
		String result = "";
		if(deptList.size() > 0) {
			result += "\n";
			for(int i = 0; i < deptList.size(); i++) {
				result += deptList.get(i).toString();
			}
			result += '\n';
		}
		else {
			result = "\nNo Department\n\n";
		}
		return result;
	}

	public void closeDeptManagement() {
		//----
		for(int i = 0; i < deptList.size(); i++) {
			deptList.remove(i);
		}
	}
}