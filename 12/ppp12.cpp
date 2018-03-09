#include "tools/C++/prime.h"
#include <iostream>
#include <vector>
using namespace std;
prime p;
bool contains(vector<int> v, int n){
	for (int i=0; i<v.size(); ++i)
		if (v.at(i) == n) return true;
	return false;
}

int factors(int n){
	if (p.isPrime(n)) return 2;
	int odd = (n%2==0)?1:2,d;	
	vector<int> v;
	v.push_back(n);
	v.push_back(1);
	for (int i=1; i<(n/2); i+=odd){
		if (n%i==0&&!contains(v, i)){
			v.push_back(i);
			d=n; 
			while (d%i==0){
				d/=i;
				if (!contains(v, d))
					v.push_back(d);
			}
		}
	}
	return v.size();
}

int tn(int i){
	return (((i*(i-1))/2)+i);
}
int main(int argc, char** argv){
	int n=0, i=1, np = 0;
	while (n<500){
		n = factors(tn(++i));
		if (n>np){
			cout<<n<<endl;
			np = n;
		}
	}
	cout<<tn(i)<<" = term "<<i<<endl;
	cout<<factors(tn(i))<<endl;
}