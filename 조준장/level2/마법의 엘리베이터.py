def solution(storey):
    answer = 0
    
    while storey:
        current = storey % 10
        
        if current > 5:
            answer += 10 - current
            storey += 10
            
        elif current < 5:
            answer += current
            
        else:
            if (storey // 10) % 10 > 4:
                storey += 10
            answer += current
        
        storey //= 10
        
    return answer
