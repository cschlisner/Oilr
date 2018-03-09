import tools.*;
class q030 {
	public static void main(String[] args){
		int i = 2, total = 0;
		while (true){
			String[] d = String.valueOf(i).split("");
			int sum = 0;
			for (String s : d)
				sum += Math.pow(Double.valueOf(s), 5.0);
			if (sum == i){
				total += i;
				Print.sln(i+" : "+total);
			}
			++i;
		}
	}
}