import tools.*;
import java.lang.reflect.Array;
class q024 {
	public static void main(String[] args){
		Integer[] t = {1,2,3,4,5,6,7,8,9};
		Print.array(permute(t,-1));
	}

	public static <T> T[][] permute(T[] obj, int stop){
		int x = obj.length;
		int xf = List.factorial(x);  	   // xf = x!
		if (stop==-1) stop=xf;
		T[][] permutations = (T[][]) Array.newInstance(obj.getClass().getComponentType(), xf, x);
		T[][] elemSets = (T[][]) Array.newInstance(obj.getClass().getComponentType(), x, x);; // Set of available elements for each column (0 - x-1)
									  	  // Set for column 0 = a0 = {obj}
									  	  // Set for column 1 = a1 = {obj - a0(i)} where a0(i) = element of a0 at row i
		elemSets[0] = obj;

		int[] ranges = new int[x];   	  // range for each element set (a0, a1, a2 ... ax-1)
										  // range is amount of permutations before next element
								      	  // range for a0 = x!/x, a1 = x!/x/x-1, a2 = x!/x-1/x-2 ... ax-1 = x!/x-1/x-2.../1
		ranges[0] = xf/x;
		for (int i=1; i<x; ++i)
			ranges[i] = ranges[i-1]/(x-i);

		for (int i=0; i<stop; ++i){
			for (int j=0, l=0; j<x; ++j, l=0){
				if (j < x-1){			  						 // this sets each element set each permutation because at least one changes every permutation ( range of ax-1 = 1) 
					for (int k=0; k<x; ++k){   					 // for each element in element set
						if (k!=modulus(i,j,ranges)/ranges[j]) 	 // check if it is currently "selected"
							elemSets[j+1][l++] = elemSets[j][k]; // if not, add it to the next element set over to attain ax = {obj - ax-1}
					}
				}
				permutations[i][j] = elemSets[j][(modulus(i,j,ranges) / ranges[j])];
			}
		}	
		return permutations;
	}

	private static int modulus (int row, int set, int[] ranges){ // needed to determine when to switch to next element
		int n = row;
		for (int i = 0; i<set; ++i)
			n = n % ranges[i];
		return n;
	}
}

class T {

}