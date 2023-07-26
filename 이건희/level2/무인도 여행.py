from collections import deque

def solution(maps):
    result = []
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    lenX = len(maps)
    lenY = len(maps[0])
    visited = [[0] * lenY for _ in range(lenX)]
    
    def land(x, y):
        q = deque()
        q.append((x, y))
        visited[x][y] = 1
        cnt = int(maps[x][y])
        
        while q:
            cx, cy = q.popleft()
            
            for i in range(4):
                nx = cx + dx[i]
                ny = cy + dy[i]
                
                if 0 <= nx < lenX and 0 <= ny < lenY and maps[nx][ny] != 'X':
                    if not visited[nx][ny]:
                        visited[nx][ny] = 1
                        cnt += int(maps[nx][ny])
                        q.append((nx, ny))
                    
        return cnt 
    
    for i in range(lenX):
        for j in range(lenY):
            if maps[i][j] != 'X' and not visited[i][j]:
                cnt = land(i, j)
                result.append(cnt)
        
    return sorted(result) if result else [-1]
