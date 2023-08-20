def solution(targets):
    result = 0
    now = 0
    
    for i, j in sorted(targets):
        if i < now:
            now = min(now, j)
        else:
            now = j
            result += 1
        print(now, result)    
    return result
