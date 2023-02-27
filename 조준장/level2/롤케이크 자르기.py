from collections import Counter

def solution(topping):
    answer = 0
    a = Counter(topping)
    b = set()
    
    for t in topping:
        a[t] -= 1
        b.add(t)
        
        if a[t] == 0:
            del a[t]
    
        if len(a) == len(b):
            answer += 1
    
    return answer
