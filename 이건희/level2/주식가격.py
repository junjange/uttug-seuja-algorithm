def solution(prices):
    result = []
    
    for i in range(len(prices)):
        cnt = 0
        for j in range(i + 1, len(prices)):
            cnt += 1
            if prices[i] > prices[j]:
                break
        result.append(cnt)
        
    return result
