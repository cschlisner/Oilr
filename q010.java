import tools.*;
class q010{
	public static void main(String args[]){
		long sum = 0;
		int[] a = Prime.getPrimes(2000000);
		for (int i : a)
			sum += i;
		System.out.println("\n\nsum: "+sum);
	}
}