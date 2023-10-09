from collections import deque

def solution(maps):
    w = len(maps[0])
    h = len(maps)
    mx = [0, 0, 1, -1]
    my = [1, -1, 0, 0]
    
    for i in range(h):
        for j in range(w):
            if maps[i][j] == 'S':
                start = (i, j)
            elif maps[i][j] == 'L':
                lever = (i, j)
            elif maps[i][j] == 'E':
                end = (i, j)
    
    def move(start, end):
        q = deque()
        visited = [[0 for _ in range(w)] for _ in range(h)]
        q.append(start)
        
        while q:
            y, x = q.popleft()

            for i in range(4):
                dx = x + mx[i]
                dy = y + my[i]
                
                if 0 <= dx < w and 0 <= dy < h and visited[dy][dx] == 0 and maps[dy][dx] != "X":
                    visited[dy][dx] = visited[y][x] + 1
                    q.append((dy, dx))
                    
        return visited[end[0]][end[1]]
    
    leverNum = move(start, lever)
    endNum = move(lever, end)
    
    return leverNum + endNum if leverNum and endNum else -1
