import tools.*;
import java.util.Vector;
import java.math.*;
class test {
	public static void main(String args[]){
		int n=0, n1 = 0, t=0, triNums = 15000;
		Vector<Integer> triangles = new Vector<Integer>();		
		//get all triangle numbers divisible by 12; highest factors only goes up when #%6==0
		for (int i=1; i<=triNums; ++i){	
			t = ((i * (i-1))/2)+i;
			//if (t%12==0)
				triangles.addElement(t);	
			t=0;
		}
		System.out.println("triangles.size() = "+triangles.size());
		System.out.println("triangles.firstElement() = "+triangles.firstElement());		
		System.out.println("triangles.lastElement() = "+triangles.lastElement());
		//check each triangle number for # factors > 500
		for (int i : triangles){
			n1 = factors.getFactors(i).size();
			t=i;
			if (n1>=500)
				break;
		}
		System.out.println(t+" has "+n1+" factors");
	}
}