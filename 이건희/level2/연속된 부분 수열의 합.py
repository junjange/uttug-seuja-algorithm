def solution(sequence, k):
    result = []
    sumNum = 0
    now = 0
    s = 0

    while now < len(sequence):
        sumNum += sequence[now]
        
        if sumNum > k:
            while sumNum > k:
                sumNum -= sequence[s]
                s += 1
        
        if sumNum == k:
            if len(result) == 0 or now - s < result[1] - result[0]:
                result = [s, now]
                
        now += 1
        
    return result                
