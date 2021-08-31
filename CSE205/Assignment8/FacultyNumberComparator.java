import java.util.Comparator; 
public class FacultyNumberComparator implements Comparator<Department>

{
	public int compare(Department first, Department second) {
		int result = 0;
		Department dep1 = first;
		Department dep2 = second;
		if(dep1.getNumOfMembers() < dep2.getNumOfMembers()) {	//Compares number of faculty
			 result = -1;
		}
		else if(dep1.getNumOfMembers() > dep2.getNumOfMembers()) {
			 result = 1;
		}
		else {
			 result = 0;
		}
		return result;
	}

}
