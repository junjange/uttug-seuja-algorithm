def solution(n, computers):
    result = 0
    visited = []

    def check(x, visited):
        for i in range(n):
            if computers[x][i] == 1 and i not in visited:
                visited.append(i)
                check(i, visited)
                
    for i in range(n):
        if i not in visited:
            visited.append(i)
            result += 1
            check(i, visited)
    print(visited)        
    return result
