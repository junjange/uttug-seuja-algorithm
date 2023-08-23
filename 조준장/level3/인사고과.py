def solution(scores):
    wanho = scores[0]
    scores = sorted(scores[1::], key=lambda x : (-x[0], x[1]))
    
    rank = 1
    target = 0
    
    for score in scores:
        
        if wanho[0] < score[0] and wanho[1] < score[1]:
            return -1            
                    
        if target <= score[1]:
            target = score[1]
            if sum(wanho) < sum(score):
                rank += 1
            
    return rank
