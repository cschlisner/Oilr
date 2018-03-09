import tools.*;
import java.util.Vector;
class q023 {
		public enum abundance {A, D, P};

		public static void main(String args[]){
			Vector<Integer> abundantNums = new Vector<Integer>();  	

			int max = 28125;

			for (int i = 1; i <= max; ++i){
				if (!abundantNums.contains(i) && isAbundant(i).equals(abundance.A)){
					abundantNums.add(i);
					for (int j = i*2; j <= max; j+=i) // add all multiples of i
						abundantNums.add(j);
				}
			}

			boolean[] sieve = new boolean[max+1];

			for (int i = 1; i <= max; ++i)
				sieve[i] = true;

			for (Integer i : abundantNums)
				for (Integer k : abundantNums)
					if (i+k <= max)
						sieve[i+k] = false;

			int sum = 0;
			for (int i = 1; i <= max; ++i)
				if (sieve[i])
					sum += i;
				
			Print.sln(sum);
		}

		private static int getSum(int n){
			int s = 0;
			for (int i = 0; i <= n; ++i){
				s+=i;
			}
			return s;
		}

		private static abundance isAbundant(int n){
			if (Prime.isPrime(n)) return abundance.D;
			int sum = 0;
			Vector<Integer> facts = Factors.getFactors(n, true); //gets PROPER divisors
			for (int i = 0; i < facts.size(); ++i)
				sum += facts.elementAt(i);
			return (sum>n)?abundance.A:(sum==n)?abundance.P:abundance.D;
		}
}

