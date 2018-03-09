class q027 {
	public static void main(String args[]){
		int range = 1000, p1=0, p2=0, r=0, a=0, b=0;
		for (int i=-range; i<range; ++i){
			for (int j=range; j>-range; --j){
				p1 = calcPrimes(i, j);
				if (i%10==0)
					System.out.print("."); //One dot for every 10,000 iterations
				if (p1>p2){
					p2=p1;
					r=i*j;
					a=i;
					b=j;
				}
			}
		}
		System.out.println("a= "+a+" b="+b+" "+r);
	}
	private static int calcPrimes(int a, int b){
		//n^2 + an + b
		int primes=0, n=0; 
		while (isPrime((++n*n)+((a)*n)+(b)))
			++primes;
		return primes;
	}
	private static boolean isPrime(int i){	
		i = (i<0)?-i:i;
		for (int j=2; j<(i/2); ++j)
			if (i%j==0)
				return false;
		return true;	   		
	}
}