class q005 {
	   public static void main(String args[]){	
	   		long a=0; 
	   		int f=0;
	   		boolean stop=false;
	   		while (!stop){
	   			++a;
	   			for (int i=1; i<=20; ++i){
	   				if (a%i==0)
	   					++f;
	   				else {
	   					f=0;
	   					break;
	   				}
	   			}
	   			if (f==20)
	   				stop=true;
	   		}
	   		System.out.println(a);
	   	}
}