def solution(cards):
    result = [0]

    while cards.count(0) != len(cards):
        cnt = 0
        idx = 0
        
        for i in cards:
            if i != 0:
                idx = i - 1
                
        while cards[idx] != 0:
            cnt += 1
            num = cards[idx] - 1
            cards[idx] = 0
            idx = num

            
        result.append(cnt)
        
    result.sort(reverse = True)
    
    return result[0] * result[1]
