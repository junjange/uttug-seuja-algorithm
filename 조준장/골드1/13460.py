import sys
from collections import deque


def bfs(srx, sry, sbx, sby, sdepth):
    queue = deque([[srx, sry, sbx, sby, sdepth]])
    visited[srx][sry][sbx][sby] = True
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    while queue:

        rx, ry, bx, by, depth = queue.popleft()

        if depth > 10:
            break

        for i in range(4):
            nrx, nry, rcnt = move(rx, ry, dx[i], dy[i])
            nbx, nby, bcnt = move(bx, by, dx[i], dy[i])


            if graph[nbx][nby] != "O":

                if graph[nrx][nry] == "O":
                    print(depth)
                    return

                if nrx == nbx and nry == nby:
                    if rcnt > bcnt:
                         nrx -= dx[i]
                         nry -= dy[i]
                    else:
                        nbx -= dx[i]
                        nby -= dy[i]
                if not visited[nrx][nry][nbx][nby]:
                    visited[nrx][nry][nbx][nby] = True

                    queue.append([nrx, nry, nbx, nby, depth+1])

    print(-1)


def move(x, y, dx, dy):
    cnt = 0
    while graph[x + dx][y + dy] != "#" and graph[x][y] != "O":
        x += dx
        y += dy
        cnt += 1

    return x, y, cnt


n, m = map(int, sys.stdin.readline().split())
visited = [[[[False] * m for _ in range(n)] for _ in range(m)] for _ in range(n)]
graph = []
init_rx, init_ry, init_bx, init_by = 0, 0, 0, 0
for i in range(n):
    temp_graph = list(map(str, sys.stdin.readline().strip()))
    for j in range(m):
        if temp_graph[j] == "R":
            init_rx = i
            init_ry = j

        elif temp_graph[j] == "B":
            init_bx = i
            init_by = j

    graph.append(temp_graph)

bfs(init_rx, init_ry, init_bx, init_by, 1)

