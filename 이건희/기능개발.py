from math import ceil

def solution(progresses, speeds):
    result = []
    cnt = 1
    day = 0
    
    for i in range(len(progresses)):
        num = ceil((100 - progresses[i]) /speeds[i])
        if day < num:
            day = num
            result.append(cnt)
            cnt = 1
        else:
            cnt += 1
            
    return result[1:] + [cnt]
