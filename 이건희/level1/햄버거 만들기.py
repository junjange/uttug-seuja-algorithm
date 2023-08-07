def solution(ingredient):
    result = 0
    lenNum = []
    now = 2
    
    while len(set(lenNum)) == len(lenNum):
        for i in range(now - 2, len(ingredient) - 3):
            if ingredient[i:i+4] == [1,2,3,1]:
                result += 1
                del ingredient[i:i+4]
                now = i
                break
                
        lenNum.append(len(ingredient))
    return result
