from collections import deque


def solution(m, n, puddles):

    queue = deque([[0, 0]])
    visited = [[0]*m for _ in range(n)]
    visited[0][0] = 1
    
    # 물에 잠긴 구역을 접근하게 쉽게 변환
    new_puddles = []
    for puddle in puddles:
        new_puddles.append([puddle[1]-1, puddle[0]-1])
    
    dx = [1, 0]
    dy = [0, 1]
    
    while queue:
        x, y = queue.popleft()
        
        for i in range(2):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < m:
                if [nx, ny] not in new_puddles:
                    if visited[nx][ny] > 0:
                        visited[nx][ny] += visited[x][y] % 1000000007
                    
                    else:
                        visited[nx][ny] = visited[x][y]
                        queue.append([nx, ny])
                    
                    
    return visited[n-1][m-1] % 1000000007
