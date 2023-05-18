def solution(cards):
    answer = []
    visited = [False] * len(cards)
    
    
    while not all(visited):
        for i in range(len(cards)):
            if not visited[i]:
                target = i
                break
        
        cnt = 0
        while True:
            if visited[target]:
                break
            visited[target] = True
            target = cards[target]-1
            cnt += 1
            
        answer.append(cnt)
        
    
    if len(answer) > 1:
        answer.sort(reverse = True)
        return answer[0] * answer[1]
    return 0

