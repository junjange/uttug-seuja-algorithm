import sys
from collections import deque


def bfs(sx, sy):
    global answer
    queue = deque([[sx, sy, graph, 1]])
    visited = [[False for _ in range(c)] for _ in range(r)]
    visited[sx][sy] = True
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    while queue:
        x, y, new_grpah, cnt = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < r and 0 <= ny < c and not visited[nx][ny]:
                
                if new_grpah[nx][ny] == "H":
                    answer = min(answer, cnt)
                    continue
                
                if new_grpah[nx][ny] == ".":
                    visited[nx][ny] = True
                    flag, shower_grpah = create_shower(x, y, nx, ny, new_grpah)
                    if flag:
                        queue.append([nx, ny, shower_grpah, cnt + 1])


def create_shower(x, y, wx, wy, graph):
    new_graph = [g[:] for g in graph]
    new_graph[x][y] = "."
    new_graph[wx][wy] = "W"
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    for i in range(r):
        for j in range(c):
            if graph[i][j] == "*":                
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if 0 <= nx < r and 0 <= ny < c:
                        if new_graph[nx][ny] == "W":
                            return False, []
                        if new_graph[nx][ny] == ".":
                            new_graph[nx][ny] = "*"
    return True, new_graph
                    

r, c = map(int, sys.stdin.readline().split())
graph = [list(map(str, sys.stdin.readline().strip("\n"))) for _ in range(r)]
answer = 1e9

for i in range(r):
    for j in range(c):
        if graph[i][j] == "W":
            bfs(i, j)
            break

if answer == 1e9:
    print("FAIL")
else:
    print(answer)
