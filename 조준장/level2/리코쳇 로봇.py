from collections import deque


def solution(board):
    
    def move(x, y, d):
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
    
        while True:
            nx = x + dx[d]
            ny = y + dy[d]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= m or board[nx][ny] == "D":
                return x, y
        
            x = nx
            y = ny
    
        return x, y

    rx, ry = 0, 0
    n = len(board)
    m = len(board[0])
    
    for i in range(n):
        for j in range(m):
            if board[i][j] == "R":
                rx = i
                ry = j
    
    visited = [[False for _ in range(m)] for _ in range(n)]
    visited[rx][ry] = True
    queue = deque([[rx, ry, 0]])
    
    while queue:
        x, y, depth = queue.popleft()
        
        if board[x][y] == "G":
            return depth
            
        for i in range(4):
            nx, ny = move(x, y, i)
            if not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append([nx, ny, depth+1])
    
    return -1
