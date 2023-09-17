from collections import deque

def solution(m, n, puddles):
    answer = 0
    queue = deque([[0, 0]])
    dx = [0, 1]
    dy = [1, 0]
    visited = [[0 for _ in range(m)] for _ in range(n)]
    visited[0][0] = 1
    
    while queue:
        x, y = queue.popleft()
        
        for i in range(2):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < m:
                if [ny+1, nx+1] not in puddles:
                    visited[nx][ny] += visited[x][y] % 1000000007
                    if [nx, ny] not in queue:
                        queue.append([nx, ny])
    
    
    return visited[n-1][m-1] % 1000000007
