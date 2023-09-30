from collections import deque

def check(x, y, r, c):
    return abs(r - x) + abs(c - y)

def bfs(n, m, x, y, r, c, k):
    dx = [1, 0, 0, -1]
    dy = [0, -1, 1, 0]
    dirs = ["d", "l", "r", "u"]
    
    queue = deque([[x, y, ""]])
    
    while queue:
        tx, ty, tk = queue.pop()
        
        if tx == r and ty == c:
            if k == len(tk):
                return tk
            elif (k - len(tk)) % 2 == 1:
                return "impossible"
                
        new_queue = deque([])
        for i in range(4):
            nx = tx + dx[i] 
            ny = ty + dy[i]
            if 0 < nx <= n and 0 < ny <= m and check(nx, ny, r, c) + len(tk) < k:
                new_queue.appendleft([nx, ny, tk+dirs[i]])
        queue += new_queue
                
    return "impossible"
    
def solution(n, m, x, y, r, c, k):
    return bfs(n, m, x, y, r, c, k)
