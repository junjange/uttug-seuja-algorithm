from collections import Counter

def solution(want, number, discount):
    result = 0
    
    for i in range(len(discount) - 9):
        things = Counter(discount[i : i + 10])
        cnt = 0
        for i in range(len(want)):
            if things[want[i]] == number[i]:
                cnt += 1
        if cnt == len(want):
            result += 1
            
    return result
