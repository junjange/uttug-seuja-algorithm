import sys


def rotation(graph, l):
    new_graph = [[0] * len_graph for _ in range(len_graph)]

    # rotate
    r_size = 2 ** l  # 격자 사이즈
    for x in range(0, len_graph, r_size):  # 격자 시작 좌표 y축
        for y in range(0, len_graph, r_size):  # 격자 시작 좌표 x축
            for i in range(r_size):  # 열 인덱스
                for j in range(r_size):  # 행 인덱스
                    new_graph[x+i][y+j] = graph[x + (r_size - 1 - j)][y + i]

    return new_graph


def melt_ice(graph):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    new_graph = [[0] * len_graph for _ in range(len_graph)]

    for x in range(len_graph):
        for y in range(len_graph):
            ice_cnt = 0
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < len_graph and 0 <= ny < len_graph:
                    if graph[nx][ny] > 0:
                        ice_cnt += 1

            if ice_cnt < 3:
                new_graph[x][y] = graph[x][y] - 1
            else:
                new_graph[x][y] = graph[x][y]

    return new_graph


def answer_ice(graph):
    max_ice = 0
    sum_ice = 0
    visited = [[False] * len_graph for _ in range(len_graph)]

    for i in range(len_graph):
        for j in range(len_graph):
            if graph[i][j] > 0 and not visited[i][j]:

                dx = [1, -1, 0, 0]
                dy = [0, 0, 1, -1]
                queue = [[i, j]]
                cnt = 1
                visited[i][j] = True
                while queue:
                    x, y = queue.pop()
                    sum_ice += graph[x][y]

                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]

                        if 0 <= nx < len_graph and 0 <= ny < len_graph:
                            if graph[nx][ny] > 0 and not visited[nx][ny]:
                                visited[nx][ny] = True
                                queue.append([nx, ny])
                                cnt += 1

                max_ice = max(max_ice, cnt)
                
    print(sum_ice)
    print(max_ice)



n, q = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(2 ** n)]
L = list(map(int, sys.stdin.readline().split()))
len_graph = 2**n

for l in L:
    graph = rotation(graph, l)
    graph = melt_ice(graph)

answer_ice(graph)
