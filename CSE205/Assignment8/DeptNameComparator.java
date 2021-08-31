import java.util.Comparator; 

public class DeptNameComparator implements Comparator<Department>
{
	public int compare(Department first, Department second) {
		int result = 0;
		if(first.getDeptName().compareTo(second.getDeptName()) < 0) {	//If first is less than second
			result = -1;
		}
		else if(first.getDeptName().compareTo(second.getDeptName()) > 0) {	//If first is greater than second
			result = 1;
		}
		else if (first.getDeptName().compareTo(second.getDeptName()) == 0){	//If first and second are even
			result = 0;
		}
		return result;
		
	}

}
