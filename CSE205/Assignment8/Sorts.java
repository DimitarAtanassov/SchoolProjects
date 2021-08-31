//   Assignment: ASU CSE205 Spring 2021 #8
//         Name: Dimitar Atanassov
//    StudentID: 1217419086
//      Lecture: 4:30 - 5:45
//  Description: Sorts the deptList

import java.util.Comparator;
import java.util.ArrayList;

public class Sorts
{
	
	public static void sort(ArrayList<Department> deptList, Comparator<Department> xComparator) {

		//----
		//----
		//20,12,3,4,5
		for(int i = 0; i < deptList.size(); i++) {
			Department min = deptList.get(i);	//min = 20
			int min_index = i;	//0
			for(int j = i + 1; j < deptList.size(); j++) {
				if(xComparator.compare(deptList.get(j),min) < 0) {
					min = deptList.get(j);	//min =3
					min_index = j;	//min_index = 2
				}
				
			}
			//Want to swap 3 and 20
			Department temp = deptList.get(i);	//Holds 20
			deptList.set(i,min); 	//Index @, onj   //@ index i which is 0 put min which is 3
			deptList.set(min_index, temp);	//At the index where the min value was put the higher value
			
		}
	} //end sort
} //end class Sorts
