from collections import Counter

def solution(weights):
    result = 0
    weightList = Counter(weights)
    
    for i, j in weightList.items():
        if j > 1:
            result += j * (j - 1) / 2
            
    num = [1/2, 2/3, 3/4]
    weights = list(set(weightList))
    
    for i in weights:
        for j in num:
            if i * j in weights:
                result += weightList[i] * weightList[i * j]
                
    return result
