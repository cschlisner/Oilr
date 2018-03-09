import tools.*;

class q028 {
	public static void main(String[] args){
		int max = 1001;
		int e = 3, i = 1, sum = 0;

		do {
			sum += i;
			i += e-1;
			if (i == e*e) e += 2;
		} while (i <= max*max);

		Print.sln(sum);
	}
}