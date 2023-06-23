def solution(clothes):
    result = 1
    cnt = {}
    
    for i in clothes:
        cloth_type = i[1]
        if cloth_type in cnt:
            cnt[cloth_type] += 1
        else:
            cnt[cloth_type] = 1
            
    for i in cnt:
        result *= cnt[i] + 1
        
    return result - 1
