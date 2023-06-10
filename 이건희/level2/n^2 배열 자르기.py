def solution(n, left, right):
    result = []
    
    for i in range(left, right + 1):
        if i //n >= i % n:
            result.append(i // n + 1)
        else:
            result.append(i % n + 1)
    
    return result
