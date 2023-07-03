from collections import Counter

def solution(topping):
    result = 0
    bro = Counter(topping)
    chulsu = set()
    
    for i in topping:
        bro[i] -= 1
        if bro[i] == 0:
            del bro[i]
        chulsu.add(i)
        
        if len(bro) == len(chulsu):
            result += 1
            
    return result
