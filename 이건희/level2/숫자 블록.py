import math

def solution(begin, end):
    result = []
    
    
    def cal(n):
        if n == 1:
            return 0
        num = [1]
        
        for i in range(2, int(math.sqrt(n)) + 1):
            if n % i == 0:
                num.append(i)
                if n // i <= 1e7 and n // i != n:
                    num.append(n // i)
                
        return max(num)
        
    for i in range(begin, end + 1):
        result.append(cal(i))
        
    return result
