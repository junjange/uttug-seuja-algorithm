def solution(a):
    answer = set([a[0], a[-1]])
    
    target = a[0]
    for _a in a:
        if target > _a:
            answer.add(_a)
            target = _a
            
    a.reverse()
    target = a[0]
    for _a in a:
        if target > _a:
            answer.add(_a)
            target = _a
            
    return len(answer)
