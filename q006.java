class q006 {
	   public static void main(String args[]){	
	   		long a=0, b=0; 
	   		for (int i=0; i<101; ++i){
	   			a+=i;
	   			b+=(i*i);
	   		}
	   		System.out.println((a*a)-b);
	   	}
}