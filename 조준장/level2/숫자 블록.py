def get_max_divisor(n):
    if n == 1:
        return 0
    
    arr = []
    
    for i in range(2,int(n**0.5)+1):
        if n % i == 0:
            arr.append(i)
            if n // i <= 10000000:
                return n // i
    if len(arr) >= 1:
        return arr[-1]
    return 1

def solution(begin, end):
    answer = []
    
    for i in range(begin, end+1):
        max_divisor=get_max_divisor(i)
        answer.append(max_divisor)
        
    return answer
