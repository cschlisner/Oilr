#include <stdio.h>

int getReversed(int n) {
    int reversedInteger = 0, remainder;
    while( n!=0 )
    {
        remainder = n%10;
        reversedInteger = reversedInteger*10 + remainder;
        n /= 10;
    }
    return reversedInteger;
}

int palindrome(){
    int i;
    for (i=998001; i>10000; --i){
        if (getReversed(i)!=i)
            continue;
        else {
            for (int j = 999; j>=100; --j)
                if (i%j==0 && 999>i/j && i/j>100)
                    return i;
        }
    }
    return 0;
}

int main() {
    int i = palindrome();

    printf("%d\n", i);

    return 0;
}