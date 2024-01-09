"""
- 그래프
"""
import sys
from collections import deque


def bfs(x, y):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    queue = deque([[x, y, 1]])
    visited[x][y] = 0
    while queue:
        sx, sy, depth = queue.popleft()

        for i in range(4):
            nx = sx + dx[i]
            ny = sy + dy[i]

            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == -1:
                if graph[nx][ny] == 0:
                    visited[nx][ny] = 0

                else:
                    visited[nx][ny] = depth
                    queue.append([nx, ny, depth + 1])


n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
visited = [[-1] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            bfs(i, j)

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            visited[i][j] = 0


for i in range(n):
    print(*visited[i])
