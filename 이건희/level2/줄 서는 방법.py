import math

def solution(n, k):
    result = []
    num = [i for i in range(1, n + 1)]
    n -= 1
    k -= 1
    
    while len(num) != 0:
        share = k // math.factorial(n)
        k = k % math.factorial(n)
        n -= 1
        result.append(num.pop(share))
    return result
