import sys
import copy


def fine_dust_spread():
    temp_graph = copy.deepcopy(graph)
    for x in range(r):
        for y in range(c):
            fine_dust = 0
            if graph[x][y] > 0:
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]

                    if 0 <= nx < r and 0 <= ny < c and graph[nx][ny] != -1:
                        temp_graph[nx][ny] += graph[x][y] // 5
                        fine_dust += graph[x][y] // 5

                temp_graph[x][y] -= fine_dust

    return temp_graph


def air_cleaner_top():
    x = top
    y = 1
    d = 0
    prev = 0

    while True:
        nx = x + dx[d]
        ny = y + dy[d]

        if x == top and y == 0:
            break
        if not 0 <= nx < r or not 0 <= ny < c:
            d += 1
            continue

        graph[x][y], prev = prev, graph[x][y]
        x, y = nx, ny


def air_cleaner_bottom():
    x = bottom
    y = 1
    d = 0
    prev = 0

    while True:
        nx = x + (dx[d] * -1)
        ny = y + dy[d]

        if x == bottom and y == 0:
            break
        if not 0 <= nx < r or not 0 <= ny < c:
            d += 1
            continue

        graph[x][y], prev = prev, graph[x][y]
        x, y = nx, ny


r, c, t = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(r)]
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

for i in range(r):
    if graph[i][0] == -1:
        top = i
        bottom = i + 1
        break

for _ in range(t):
    graph = fine_dust_spread()
    air_cleaner_top()
    air_cleaner_bottom()

answer = sum([sum(g) for g in graph]) + 2
print(answer)
