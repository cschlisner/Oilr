def prime_sieve(n):
    primes = [True for i in range(n)]
    for i in range(2,int(n**(0.5))+1):
        if primes[i]:
            for mult in range(2*i, n, i):
                primes[mult] = False
    return [i for i in range(2,n) if primes[i]]

def isCircularPrime(n):
    d = [x for x in str(n)]
    for rotation in range(len(d)):
        if int(''.join(d)) not in primes:
            return False
        ld = d[0]
        d = d[1:]
        d.append(ld)
    return True

N = 1000000
primes = set(prime_sieve(N))
bad_digits = [2,4,5,8,6]
c = []

for p in primes:
    if (isCircularPrime(p)):
        c.append(p)

print(c, len(c))