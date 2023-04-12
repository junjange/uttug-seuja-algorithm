import math

def solution(n, k):
    answer = []
    num = [i for i in range(1, n+1)]
    
    while n != 0:
        n_factorial = math.factorial(n-1)
        idx, k = divmod(k, n_factorial)
        if k == 0:
            answer.append(num.pop(idx-1))
        else:
            answer.append(num.pop(idx))
        n -= 1
        
    return answer
