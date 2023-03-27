import sys


# 모든 냄새 정보 업데이트
def update_smell():
    for i in range(n):
        for j in range(n):
            # 냄새가 남아있는 경우
            if smell[i][j][1] > 0:
                smell[i][j][1] -= 1
            # 상어가 존재하는 위치의 경우
            if graph[i][j] != 0:
                smell[i][j] = [graph[i][j], k]


n, m, k = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
sharks = list(map(int, sys.stdin.readline().split()))

directions = []
for _ in range(m):
    data = []
    for _ in range(4):
        data.append(list(map(int, sys.stdin.readline().split())))
    directions.append(data)

smell = [[[0, 0] for _ in range(n)] for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for count in range(1, 1001):
    update_smell()
    new_graph = [[0 for _ in range(n)] for _ in range(n)]

    for x in range(n):
        for y in range(n):
            # 이동할 상어를 찾는다.
            if graph[x][y] != 0:
                shark = sharks[graph[x][y]-1] # 이동할 상어의 현재 방향

                # 상어의 이동 우선 순위를 확인
                for i in directions[graph[x][y]-1][shark-1]:
                    nx = x + dx[i-1]
                    ny = y + dy[i-1]

                    # 상어 이동 가능
                    if 0 <= nx < n and 0 <= ny < n:
                        # 이동하려는 곳이 냄새가 없다면
                        if smell[nx][ny][1] == 0:
                            sharks[graph[x][y]-1] = i # 현재 상어의 방향 변경

                            if new_graph[nx][ny] == 0:
                                new_graph[nx][ny] = graph[x][y]
                            else:
                                new_graph[nx][ny] = min(new_graph[nx][ny], graph[x][y])
                            break
                else:
                    # 상어의 이동 우선 순위를 확인
                    for i in directions[graph[x][y] - 1][shark - 1]:
                        nx = x + dx[i-1]
                        ny = y + dy[i-1]

                        # 상어 이동 가능
                        if 0 <= nx < n and 0 <= ny < n:
                            # 자신의 냄새가 있는 곳이라면
                            if smell[nx][ny][0] == graph[x][y]:
                                sharks[graph[x][y]-1] = i
                                new_graph[nx][ny] = graph[x][y]
                                break

    graph = new_graph
    check = True
    for i in range(n):
        for j in range(n):
            if graph[i][j] > 1:
                check = False
    if check:
        print(count)
        sys.exit(0)

print(-1)








