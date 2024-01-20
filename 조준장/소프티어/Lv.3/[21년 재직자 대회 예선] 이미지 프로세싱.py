import sys
from collections import deque


def bfs(x, y, c, graph):
    visited = [[False] * w for _ in range(h)]
    visited[x][y] = True
    queue = deque([[x, y]])
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    real_c = graph[x][y]
    graph[x][y] = c
    while queue:
        sx, sy = queue.popleft()

        for i in range(4):
            nx = sx + dx[i]
            ny = sy + dy[i]
            if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny] and graph[nx][ny] == real_c:
                visited[nx][ny] = True
                graph[nx][ny] = c
                queue.append([nx, ny])
        

h, w = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(h)]
q = int(sys.stdin.readline())
q_order = [list(map(int, sys.stdin.readline().split())) for _ in range(q)]

for i, j, c in q_order:
    bfs(i-1, j-1, c, graph)

for g in graph:
    print(*g)
