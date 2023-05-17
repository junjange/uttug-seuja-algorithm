def solution(stones, k):
    answer = 0
    start = 1
    end = max(stones)
    
    while start <= end:
        cnt = 0
        mid = (start+end) // 2
        
        for stone in stones:
            if (stone - mid) <= 0:
                cnt += 1
            else:
                cnt = 0
                
            if cnt >= k:
                break
                
        if cnt >= k:
            answer = mid
            end = mid-1
            
        else:
            start = mid+1
                
        
    
    return answer
