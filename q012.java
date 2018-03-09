import tools.*;
import java.math.*;
import java.util.*;
class q12 {
	static final int FACTORS = 5;
	public static void main(String args[]){
		System.out.println(rangeFinder(0, 1000));
	}

	private static int rangeFinder(int min, int range){
		System.out.print("Trying range "+min+"-"+range);
		int ans, term=1, t=0;
		Vector<Integer> triangles = new Vector<Integer>();
		for (int i=1; i<=range; ++i){	
			if (Prime.isPrime(i)&&FACTORS>2) continue;
			t = ((i * (i-1))/2)+i;
			triangles.addElement(t);	
			t=0;
		}
		System.out.println(": v.elementAt("+range+") = "+triangles.lastElement());
		ans = lookForFactors(FACTORS, min, triangles.size()-1, triangles);
		if (ans == -1)
			rangeFinder(triangles.size()-1, triangles.size()-1+range);
		return ans; 
	}

	private static int lookForFactors(int factors, int min, int max, Vector<Integer> v){
		int iF;	
		int diff = (max-min), range = (diff>=10)?((diff)%10==0)?diff/10:(diff/10)+1:1, low = min;
		diff = (diff%range==0)?0:max-(range*9);
		System.out.println("Sorting for factors from "+min+" to "+max+" with range "+range+" diff="+diff);
		for (int i=min; i<=max+diff; i+=(diff>0&&i==range*9)?diff:range){
			iF = new Factors().getFactors(v.elementAt(i)).size();
			System.out.println("i = "+i+" iF = "+iF);
			if (iF >= factors && range == 1) return v.elementAt(i);			
			else if (iF >= factors && range > 1) {
				System.out.println("ans between "+low+" and "+i);
				return lookForFactors(factors, low, i, v);
			}
			else low = i;	
			System.out.println("end");
		}		
		System.out.println("shit, v.elementAt("+low+")="+v.elementAt(low)+" factors ="+Factors.getFactors(v.elementAt(low)).size());
		return -1;
	}
}