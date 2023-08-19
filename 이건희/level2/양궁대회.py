from itertools import combinations_with_replacement

def solution(n, info):
    result = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    score = 0
    info.reverse()
    combinations = combinations_with_replacement(range(11), n)

    for com in combinations:
        box = [0] * 11
        cnt = 0
        
        for index in com:
            box[index] += 1

        for i in range(11):
            if box[i] == 0 and info[i] == 0:
                continue
            elif box[i] > info[i]:
                cnt += i
            else:
                cnt -= i
                
        if cnt == score:
            
            for i, j in zip(box, result):
                if i == j:
                    continue
                elif i > j:
                    result = box
                    break
                else:
                    break
                    
        elif cnt > score:
            score = cnt
            result = box
            
    return result[::-1] if score != 0 else [-1]
