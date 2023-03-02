def solution(n):        
    for i in range(1, 50000000000001):
        x = i*i
        if x >= n:
            if x == n:
                return (i+1) * (i+1)
            return -1
