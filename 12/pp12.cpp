#include "tools/C++/prime.h"
#include <iostream>
#include <vector>
using namespace std;

bool contains(vector<int> v, int n){
	for (int i=0; i<v.size(); ++i)
		if (v.at(i) == n) return true;
	return false;
}

int findMeSomeMotherFuckingFactors(int n){
	int d;	
	vector<int> v;
	v.push_back(n);
	v.push_back(1);
	for (int i=1; i<(n/2); ++i){
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
	return ( ( ( i * ( i - 1 ) ) / 2 ) + i );
}
int main(int argc, char** argv){
	int n=0, i=1, np = 0;
	while (n<500){
		n = findMeSomeMotherFuckingFactors(tn(++i));
	}
	cout<<tn(i)<<" = term "<<i<<endl;
	cout<<findMeSomeMotherFuckingFactors(tn(i))<<endl;
}