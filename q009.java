class q009 {
	public static void main(String args[]){
		for (int i=0; i<1000; ++i)
			for (int j=0; j<1000; ++j)
				for (int k=0; k<i+j; ++k)
					if (i+j+k==1000 && (i*i)+(j*j)==(k*k))
						System.out.println(i+" "+j+" "+k);
	}
	
}