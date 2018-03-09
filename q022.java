import tools.*;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;
class q022 {
	public static void main(String[] args){
		Vector<String> namev = getNames("22/names.txt");
		if (namev != null){
			String[] names = new String[namev.size()];
			namev.toArray(names);
			names = Sort.alphabetical(names);
			int ans = 0;
			for (int i=0; i<names.length; ++i){
				ans += (i+1)*getScore(names[i]);
			}
			Print.sln(ans);
		}
	}

	private static int getScore(String name){
    	String alphabet = "abcdefghijklmnopqrstuvwxyz";
    	int s = 0;
    	for (int i=0; i<name.length(); ++i)
			s += alphabet.indexOf(name.toLowerCase().charAt(i))+1;
		return s;
	}

	public static Vector<String> getNames(String file){
		Vector<String> vector = new Vector<String>();
		Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(file)));
            int i=0;
            while (s.hasNext()){
            	vector.add(s.next());
            }
        } catch (FileNotFoundException e){}
        finally {
            if (s != null) {
                s.close();
            }
        }
        return vector;
	}
}