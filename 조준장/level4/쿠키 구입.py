def solution(cookie):
    answer = 0
    n = len(cookie)
    
    for i in range(n-1):
        left = cookie[i]
        left_idx = i
        
        right = cookie[i+1]
        right_idx = i+1
        
        while True:
            
            if left == right:
                answer = max(answer, left)
            
            if left_idx > 0 and left <= right:
                left_idx -= 1
                left += cookie[left_idx]
            
            elif right_idx < n-1 and left >= right:
                right_idx += 1
                right += cookie[right_idx]
                
            else:
                break
                
            
            
    
    return answer
