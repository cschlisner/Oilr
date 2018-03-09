#include "tools/C++/prime.h"
#include <iostream>
#include <vector>
using namespace std;
prime p;
int numprimes =0;
bool contains(vector<int> v, int n){
	for (int i=0; i<v.size(); ++i)
		if (v.at(i) == n) return true;
	return false;
}

int findMeSomeMotherFuckingFactors(int n){
	if (p.isPrime(n)) return 2;
	int odd = (n%2==0)?1:2, d;	
	vector<int> v;
	v.push_back(n);
	v.push_back(1);
	for (int i=1; i<(n/2); i+=odd){
		if (n%i==0&&!contains(v, i)){
			if (p.isPrime(i)) ++numprimes;
			v.push_back(i);
			d=n;
			while (d%i==0){
				d/=i;
				if (!contains(v, d)){
					if (p.isPrime(d)) ++numprimes;
					v.push_back(d);
				}
			}
		}
	}
	return v.size();
}

int tn(int i){
	return ( ( ( i * ( i - 1 ) ) / 2 ) + i );
}

int average(vector<int> v){
	int a;
	for (int i=0; i<v.size(); ++i)
		a+=v.at(i);
	return a/=v.size();
}

vector<int> rangeLoop(int MIN, int MAX, int SAMPLE, int FREQUENCY, int THRESHOLD){
	vector<int> v, fin;
	for (int i = MIN; i<MAX; i+=FREQUENCY){
		for (int j=i; j<i+SAMPLE; ++j)
			v.push_back(findMeSomeMotherFuckingFactors(tn(j)));
		int spavg = average(v);
		v.clear();
		if (spavg < THRESHOLD) continue;
		else {
			fin.push_back(i-FREQUENCY);
			fin.push_back(i+SAMPLE);
			return fin;
		}
		i+=SAMPLE-1;
	}
	return fin;
}

int main(int argc, char** argv){
	// MIN = what triangle number to start at
	// MAX = what triangle number to go up to
	// sample = how many triangles to sample for an average
	// frequency = how many triangles to skip in between sampling
	// threshold = number to check against
	int min = 1, max = 50000, sample = 10, frequency = 100, threshold = 50, ans=0;
	std::vector<int> v = rangeLoop(min, max, sample, frequency, threshold);
	if (v.size()>0){
		for (int i=v.at(0); i<v.at(1); ++i){
			if (findMeSomeMotherFuckingFactors(tn(i))>threshold){
				ans = tn(i);
				break;
			}
		}
	}
	cout<<ans<<endl;
}