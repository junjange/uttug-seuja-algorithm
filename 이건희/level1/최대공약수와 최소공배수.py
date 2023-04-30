def solution(n, m):
    result = n * m
    while(m):
        n, m = m, n % m
    gcd = n
    lcm = result // gcd
    return [gcd, lcm]
