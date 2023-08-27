def solution(targets):
    answer = 0
    targets.sort(key=lambda x : (x[1], x[0]))
    
    x = 0
    for start, end in targets:
        if x <= start:
            x = end
            answer += 1
            
    
    return answer
