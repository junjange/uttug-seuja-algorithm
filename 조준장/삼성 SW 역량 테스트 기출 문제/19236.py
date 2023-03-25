import sys
import copy


def dfs(sx, sy, score, graph):
    global max_score

    # 8방향 ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    dx = [-1, -1, 0, 1, 1, 1, 0, -1]
    dy = [0, -1, -1, -1, 0, 1, 1, 1]

    score += graph[sx][sy][0] # 현재 물고기 번호 더하기
    max_score = max(max_score, score) # 물고기 번호의 최댓값 갱신
    graph[sx][sy][0] = 0 # 물고기가 있는 자리 초기화

    # 1번부터 17번까지 물고기 이동
    for f in range(1, 17):
        fx = -1
        fy = -1

        # f번호의 물고기를 찾는다.
        for x in range(4):
            for y in range(4):
                if graph[x][y][0] == f:
                    fx = x
                    fy = y
                    break

        # f번호의 물고기가 없다면 continue
        if fx == -1 and fy == -1:
            continue

        # f번호의 물고기의 방향을 저장
        fd = graph[fx][fy][1]

        # f번호의 물고기를 8가지 방향중 하나의 방향으로 이동시킨다.
        for i in range(8):
            nd = (fd+i) % 8
            nx = fx + dx[nd]
            ny = fy + dy[nd]

            if not (0 <= nx < 4 and 0 <= ny < 4) or (nx == sx and ny == sy):
                continue

            graph[fx][fy][1] = nd # 이동할 곳에 방향으로 값을 초기화
            graph[fx][fy], graph[nx][ny] = graph[nx][ny], graph[fx][fy] # 이동할 곳과 이동하는 곳에 데이터를 변경
            break

    # 상어의 이동방향 저장
    sd = graph[sx][sy][1]

    # 상어가 이동 할 수 있는 방향을 확인
    for i in range(1, 5):
        nx = sx + dx[sd] * i
        ny = sy + dy[sd] * i
        if 0 <= nx < 4 and 0 <= ny < 4 and graph[nx][ny][0] > 0:
            dfs(nx, ny, score, copy.deepcopy(graph)) # dfs를 통해 상어가 먹은 물고기 번호의 최대값을 출력한다.


graph = []
for i in range(4):
    data = list(map(int, sys.stdin.readline().split()))
    fish = []
    for j in range(4):
        fish.append([data[2*j], data[2*j+1]-1])
    graph.append(fish)

max_score = 0
dfs(0, 0, 0, graph)

print(max_score)
