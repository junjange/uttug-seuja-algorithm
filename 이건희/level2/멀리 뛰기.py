def solution(n):
    result = [1, 2]
    
    for i in range(2, n):
        result.append(result[-1] + result[-2])
        
    return result[n - 1] % 1234567
