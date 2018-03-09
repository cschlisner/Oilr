class q004 {
	   public static void main(String args[]){	
	   		int i;
	   		mainloop:
			for (i=998001; i>10000; --i){
				if (reverse(i)!=i)
					continue;
				else {
					for (int j = 999; j>=100; --j)
						if (i%j==0 && 999>i/j && i/j>100)
							break mainloop;
				}
			}
			System.out.println(i);
	   }
	   private static int reverse(int n){
	   		int reversedNum=0;
	   		while (n != 0) {
			    reversedNum = reversedNum * 10 + n % 10;
			    n = n / 10;   
			}
			return reversedNum;
	   }
}