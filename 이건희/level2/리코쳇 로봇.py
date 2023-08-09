from collections import deque
INF = float('inf')

def solution(board):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    lenX = len(board)
    lenY = len(board[0])

    for i in range(lenX):
        for j in range(lenY):
            if board[i][j] == 'R':
                R = [i, board[i].index('R')]
            elif board[i][j] == 'G':
                G = [i, board[i].index('G')]
    
    Rx, Ry = R
    Gx, Gy = G
    counts = [[INF] * lenY for _ in range(lenX)]
    counts[Rx][Ry] = 0
    q = deque([[Rx, Ry, counts[Rx][Ry]]])
    
    while q:
        if counts[Gx][Gy] != INF:
            return counts[Gx][Gy]
            
        cx, cy, cnt = q.popleft()
        
        for i in range(4):
            nx, ny, ncnt = cx, cy, cnt + 1
            
            while 0 <= nx + dx[i] < lenX and 0 <= ny + dy[i] < lenY and board[nx + dx[i]][ny + dy[i]] != 'D':
                nx += dx[i]
                ny += dy[i]
                
            if ncnt < counts[nx][ny]:
                counts[nx][ny] = ncnt
                q.append([nx, ny, ncnt])
                
    return -1
