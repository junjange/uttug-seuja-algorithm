def solution(k, tangerine):
    size = {}
    result = 0
    cnt = 0
    tangerine.sort()
    
    for i in tangerine:
        if i in size:
            size[i] += 1
        else:
            size[i] = 1
            
    size_dic = sorted(size.items(), key=lambda x: x[1], reverse=True)
    
    if size_dic[0][1] >= k:
        return 1
    else:
        for i in size_dic:
            if result < k:
                cnt += 1
                result += i[1]
            else:
                break
                
    return cnt
