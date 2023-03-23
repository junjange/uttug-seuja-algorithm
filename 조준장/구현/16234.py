import sys
from collections import deque


def bfs(a, b):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    q = deque([[a, b]])
    temp = [[a, b]]
    visited[a][b] = True
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
                if l <= abs(graph[nx][ny] - graph[x][y]) <= r:
                    visited[nx][ny] = True
                    q.append([nx, ny])
                    temp.append([nx, ny])
    return temp


n, l, r = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = 0

while True:
    country = []
    visited = [[False] * (n + 1) for _ in range(n + 1)]
    flag = False
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                country = bfs(i, j)
                if len(country) > 1:
                    flag = True
                    population = (sum([graph[x][y] for x, y in country]) // len(country))

                    for x, y in country:
                        graph[x][y] = population
    if not flag:
        break
    answer += 1


print(answer)
