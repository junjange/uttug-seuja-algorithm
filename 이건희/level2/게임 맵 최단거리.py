from collections import deque

def solution(maps):

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    lenX = len(maps)
    lenY = len(maps[0])
    
    def bfs(x, y):
        q = deque()
        q.append((x,y))
        
        while q:
            x, y = q.popleft()
            
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                
                if nx < 0 or lenX <= nx or ny < 0 or lenY <= ny:
                    continue
                
                if maps[nx][ny] == 0:
                    continue
                
                if maps[nx][ny] == 1:
                    maps[nx][ny] = maps[x][y] + 1
                    q.append((nx, ny))
                    
        return maps[lenX - 1][lenY - 1]
    
    if bfs(0, 0) == 1:
        return -1
    return bfs(0, 0)
