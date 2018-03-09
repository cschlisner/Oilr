class q003 {
	   public static void main(String args[]){	   		
			long n = 600851475143L, i=2;
			while (true){
				if (i==n)
					break;
				else if ((n%i)==0){
					n=n/i;
					i=2;
					continue;
				}
				else ++i;	
			}
			System.out.println(n);
	   }
}