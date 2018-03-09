class q017 {
	public static void main(String[] args){
		int total=0;
		for (int i=1; i<1001; ++i) total+=(intToText(i).replaceAll("\\s","")).length();
		System.out.println(total);
		//System.out.println(intToText(9999));
	}
	private static String intToText(int n){
		String[] digits = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
						  "eighteen", "nineteen"};
		String numStr = String.valueOf(n);
		int lim=numStr.length();
		for (int i=0; i<(4-lim); ++i)
			numStr = "0"+numStr;
		return ((n>=1000)?digits[numStr.charAt(0)-48]+" thousand ":"")+
			   ((n>=100)?digits[numStr.charAt(1)-48]+((numStr.charAt(1)-48>0)?" hundred ":"")+((numStr.charAt(2)=='0'&&numStr.charAt(3)=='0')?"":"and "):"")+
			   ((n>=10)?(numStr.charAt(2)-48>1)?tens[(numStr.charAt(2)-48)-2]+" ":(numStr.charAt(2)-48==1)?teens[numStr.charAt(3)-48]:"":"")+
			   ((numStr.charAt(2)!='1')?digits[numStr.charAt(3)-48]:"");
	}
}