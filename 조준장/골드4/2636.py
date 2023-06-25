import sys
from collections import deque


def bfs():
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    queue = deque([[0, 0]])
    visited = [[False for _ in range(m)] for _ in range(n)]
    visited[0][0] = True
    new_graph = graph[::]
    cnt = 0
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny]:
                    visited[nx][ny] = True
                    if graph[nx][ny] == 1:
                        new_graph[nx][ny] = 0
                        cnt += 1

                    else:
                        queue.append([nx, ny])

    return new_graph, cnt


def check():
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                return False

    return True


n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
cnt = 0
for i in range(100):
    if check():
        print(i)
        print(cnt)
        break

    graph, cnt = bfs()
