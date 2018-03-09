import tools.*;

class q025 {
	public static void main(String[] args){
		int i = 3;

		Huge a = new Huge(1), b = new Huge(2), c = new Huge();
		while (c.length() < 1000){
			++i;
			c = Huge.add(b, a);
			a = b;
			b = c;
		}
		
		System.out.println(i);
	}

	private static class Huge {
		int[] d;
		public Huge(){
			d = new int[1000];
		}
		public Huge(int n){
			d = new int[1000];
			int ci = 999; // index of first digit
			String[] digits = String.valueOf(n).split("");
			for (int i = digits.length-1; i >= 0; --i)
				d[ci--] = Integer.valueOf(digits[i]);
		}
		public int length(){
			for (int i = 0; i < d.length; ++i)
				if (d[i]!=0)
					return 1000 - i;
			return 0;
		}
		public static Huge add(Huge one, Huge two){
			int overflow = 0;
			Huge res = new Huge();
			for (int i = 999; i >= 0; --i){
				int sum = two.d[i] + one.d[i] + overflow;
				if (sum >= 10){
					res.d[i] = sum - 10;
					overflow = sum / 10;
				}
				else {
					overflow = 0;
					res.d[i] = sum;
				}
			}
			return res;
		}
	}
}