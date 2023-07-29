import math

def solution(k, d):
    result = 0
    num = d ** 2
    
    for i in range(0, d + 1, k):
        y = int(math.sqrt(num - i ** 2))
        result += y // k + 1
        
    return result
