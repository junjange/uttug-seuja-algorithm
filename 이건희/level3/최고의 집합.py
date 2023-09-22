def solution(n, s):
    if s // n == 0:
        return [-1]
    
    num = s // n
    re = s % n
    result = [num] * n
    
    for i in range(1, re + 1):
        result[-i] += 1
        
    return result
