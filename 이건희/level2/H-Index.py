def solution(citations):
    result = 0
    citations.sort()
    
    for i, cnt in enumerate(citations):
        if cnt >= len(citations) - i:
            result += 1
            
    return result
