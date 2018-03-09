class q007 {
	   public static void main(String args[]){	
	   		int p=1, i=3, n=0, d=0;
	   		mainloop:
	   		while (p<10001){	   			
	   			for (int j=2; j<(i/2); ++j){
	   				if (i%j==0){
	   					i+=2;
	   					continue mainloop;
	   				}
	   			}
				++p;
				n=i;
	   			i+=2;
	   		}
	   		System.out.println("\n"+"p("+p+") = "+n);
	   	}
}