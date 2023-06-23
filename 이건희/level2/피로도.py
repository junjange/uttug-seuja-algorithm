from itertools import permutations

def solution(k, dungeons):
    result = 0
    dungeons_list = permutations(dungeons, len(dungeons))
    
    for i in dungeons_list:
        num = k
        cnt = 0
        for j in i:
            if num < j[0]:
                break
            num -= j[1]
            cnt += 1
        if cnt == len(dungeons):
            return cnt
        elif cnt > result:
            result = cnt
            
    return result
