import sys
from collections import deque


def bfs(x, y):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    queue = deque([[x, y]])

    while queue:
        sx, sy = queue.popleft()

        for i in range(4):
            nx = sx + dx[i]
            ny = sy + dy[i]

            if graph[nx % n][ny % m] == 0:
                queue.append([nx % n, ny % m])
                graph[nx % n][ny % m] = 1


n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            bfs(i, j)
            answer += 1
print(answer)
