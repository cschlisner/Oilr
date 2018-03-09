import tools.*;
import java.math.*;
import java.util.*;
class q12 {
	static final int FACTORS = 5;
	public static void main(String args[]){
		System.out.println(rangeFinder(0, 1000));
	}

	private static long rangeFinder(int min, int range){
		System.out.print("Trying range "+min+"-"+range);
		long ans, term=1, t=0;
		Vector<Long> triangles = new Vector<Long>();
		for (int i=1; i<=range; ++i){	
			if (prime.isPrime(i)&&FACTORS>2) continue;
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

	private static long lookForFactors(int factors, int min, int max, Vector<Long> v){
		long iF;	
		int diff = (max-min), range = (diff>=10)?((diff)%10==0)?diff/10:(diff/10)+1:1, low = min;
		diff = (diff%range==0)?0:max-(range*9);
		System.out.println("Sorting for factors from "+min+" to "+max+" with range "+range+" diff="+diff);
		for (int i=min; i<=max+diff; i+=(diff>0&&i==range*9)?diff:range){
			iF = new factors().getFactors(v.elementAt(i)).size();
			System.out.println("i = "+i+" iF = "+iF);
			if (iF >= factors && range == 1) return v.elementAt(i);			
			else if (iF >= factors && range > 1) {
				System.out.println("ans between "+low+" and "+i);
				return lookForFactors(factors, low, i, v);
			}
			else low = i;	
			System.out.println("end");
		}		
		System.out.println("shit, v.elementAt("+low+")="+v.elementAt(low)+" factors ="+new factors().getFactors(v.elementAt(low)).size());
		return -1;
	}
}