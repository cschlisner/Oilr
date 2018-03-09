#include <iostream>
#include <fstream>
using namespace std;
int main(){
	int colLen = 0, maxTerm = 0;
	for (int term = 1; term<1000000; ++term){
		long long t = 0, n = term;
		while (n>1){
			if (n%2==0) n/=2;
			else n=(3*n)+1;
			++t;
		}
		if (t>colLen){
			colLen = t;
			maxTerm = term;
		} 
	}
	cout<<maxTerm<<endl;
}