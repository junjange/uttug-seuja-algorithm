def solution(n):
    if n % 2 == 1:
        return 0
    
    result = [3, 11]
    if n <= 4:
        return result[n // 2 - 1]
    
    for i in range(2, n // 2):
        result.append(4 * result[i - 1] - result[i - 2])
        
    return result[-1] % 1000000007
