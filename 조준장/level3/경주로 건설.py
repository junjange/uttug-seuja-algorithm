from collections import deque

def bfs(board, vector):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    n = len(board)
    queue = deque([[0,0,0,vector]])
    visited = [[1e9] * n for _ in range(n)]
    visited[0][0] = 0
    
    while queue:
        x, y, cost, vector = queue.popleft()
        
        if x == n-1 and y == n-1:
            continue 
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0:
                if i == vector:
                    nc = cost + 100
                else:
                    nc = cost + 600
                    
                if nc < visited[nx][ny]:
                    visited[nx][ny] = nc
                    queue.append([nx, ny, nc, i])
    return visited[n-1][n-1]

def solution(board):
    return min(bfs(board, 0), bfs(board, 2))
