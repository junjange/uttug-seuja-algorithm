def solution(storey):
    result = 0
    
    while storey != 0:
        n = storey % 10 

        if n >= 6:
            storey += 10 - n
            result += 10 - n

        elif n == 5 and (storey // 10) % 10 >= 5:
            storey += 10 - n
            result += 10 - n

        else:
            result += n
            
        storey = storey // 10
        
    return result
