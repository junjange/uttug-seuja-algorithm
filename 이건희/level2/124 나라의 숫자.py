def solution(n):
    result = []
    
    while n > 0:
        t = n % 3
        if not t:
            t = 4
            n -= 1
        result.append(t)
        n //= 3
        
    return ''.join(map(str,result[::-1]))
