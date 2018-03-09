class q002 {
	   public static void main(String args[]){	   		
			int a=1, b=2, c=0, sum=2;
			while (c<4000000){
				c=b+a;
				a=b;
				b=c;
				sum+=(b%2==0)?b:0;
			}
			System.out.println(sum);
	   }
}