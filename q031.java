import tools.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
class q031 {
	public static void main(String[] args){
		int[] arr = {1, 2, 5, 10, 20, 50, 100, 200};
		int num = 200;
		int[] div = new int[arr.length];
		
		int d = 0;
		for (int i : arr)
			div[d++] = num/i;
		
		List<String> solutions = new ArrayList<String>();
		int sol =1;
		for (int i = 0; i <= div[0]; ++i){

			for (int j = 0; j <= div[1]; ++j){
				if ((i*arr[0] + j*arr[1]) > num)
					continue;

				for (int k = 0; k <= div[2]; ++k){
					if ((i*arr[0] + j*arr[1] + k*arr[2]) > num)
						continue;

					for (int l = 0; l <= div[3]; ++l){
						if ((i*arr[0] + j*arr[1] + k*arr[2] + l*arr[3]) > num)
							continue;

						for (int m = 0; m <= div[4]; ++m){
							if ((i*arr[0] + j*arr[1] + k*arr[2] + l*arr[3] + m*arr[4]) > num)
								continue; 

							for (int n = 0; n <= div[5]; ++n){
								if ((i*arr[0] + j*arr[1] + k*arr[2] + l*arr[3] + m*arr[4] + n*arr[5]) > num)
									continue;

								for (int o = 0; o <= div[6]; ++o){
									if ((i*arr[0] + j*arr[1] + k*arr[2] + l*arr[3] + m*arr[4] + n*arr[5] + o*arr[6]) > num)
										continue;

									for (int p = 0; p <= div[7]; ++p){
										if ((i*arr[0] + j*arr[1] + k*arr[2] + l*arr[3] + m*arr[4] + n*arr[5] + o*arr[6] + p*arr[7]) == num){
											System.out.print("\rsol = "+sol+++"\r");
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}