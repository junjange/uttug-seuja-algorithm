from collections import deque

def solution(maps):
    
    def bfs(a, b, target):
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        visited = [[-1 for _ in range(m)] for _ in range(n)]
        visited[a][b] = 0
        queue = deque([[a, b]])
        while queue:
            x, y = queue.popleft()
        
            if maps[x][y] == target:
                return visited[x][y]
        
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
            
                if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] != "X":
                    if visited[nx][ny] == -1:
                        visited[nx][ny] = visited[x][y] + 1
                        queue.append([nx, ny])
        
        return -1

    answer = 0
    n = len(maps)
    m = len(maps[0])
    for i in range(n):
        for j in range(m):
            if maps[i][j] == "S":
                start = [i, j]
            
            elif maps[i][j] == "L":
                lever = [i, j]
    
    start_to_lever = bfs(start[0], start[1], "L")
    if start_to_lever == -1:
        return -1
    
    lever_to_end = bfs(lever[0], lever[1], "E")
    if lever_to_end == -1:
        return -1 
        
    return start_to_lever+lever_to_end
