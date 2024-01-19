import sys
from collections import deque

def bfs(x, y):
    global sx, sy, sd
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    visited = [[False for _ in range(w)] for _ in range(h)]

    visited[x][y] = True

    queue = deque([(x, y, 0)])
   
    while queue:
        sx, sy, sd = queue.popleft()

        for i in range(4):
            nx = sx + dx[i]
            ny = sy + dy[i]

            if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny] and graph[nx][ny] == '#':
                visited[nx][ny] = True
                queue.append([nx, ny, i])


def solution(x, y, d):
    global answer

    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    visited = [[False for _ in range(w)] for _ in range(h)]

    visited[x][y] = True

    queue = deque([(x, y, d)])
   
    while queue:
        sx, sy, sd = queue.popleft()

        for i in range(4):
            nx = sx + dx[i]
            ny = sy + dy[i]

            if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny] and graph[nx][ny] == '#':
                visited[nx][ny] = True
                if sd == i:
                    answer += "a"
                elif (sd + 1) % 4 == i:
                    answer += "La"
                elif (sd + 3) % 4 == i:
                    answer += "Ra"
                queue.append([nx, ny, i])
                break
                
        

h, w = map(int, sys.stdin.readline().split())
graph = [list(map(str, sys.stdin.readline().strip("\n"))) for _ in range(h)]
sx = 0
sy = 0
sd = 0
for i in range(h):
    for j in range(w):
        if graph[i][j] == '#':
            bfs(i, j)
            break
    else:
        break

d = ""
if sd == 0:
    d = "^"
    sd = 2
elif sd == 1:
    d = "<"
    sd = 3
elif sd == 2:
    d = "V"
    sd = 0
elif sd == 3:
    d = ">"
    sd = 1
    
print(sx + 1, sy + 1)
print(d)
answer = ""
solution(sx, sy, sd)
print(answer.replace("aa", "A"))


