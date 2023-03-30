def solution(brown, yellow):
    answer = []
    width = int((brown - 4) / 2)
    
    for height in range(1, width+1):
        if (width - height) * height == yellow:
            answer.append(width - height + 2)
            answer.append(height + 2)
            break
            
    return answer
