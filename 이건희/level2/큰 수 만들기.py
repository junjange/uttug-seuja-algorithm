def solution(number, k):
    result = []
    
    for i in number:
        while result and result[-1] < i and k > 0:
            result.pop()
            k -= 1
        result.append(i)
        
    if k != 0:
        result = result[:-k]
        
    return ''.join(map(str, result))
            
