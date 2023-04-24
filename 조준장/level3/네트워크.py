def solution(n, computers):
    answer = 0
    visited = []
    queue = []
    
    for i in range(n):
        if i not in visited:
            queue.append(i)
            answer += 1
            
            while queue:
                target = queue.pop()
                
                for j in range(n):
                    if computers[target][j] == 1 and j not in visited:
                        queue.append(j)
                        visited.append(j)
                        
    return answer
