import sys


def check(check_graph):
    global answer

    for i in range(n):
        cnt = 1
        for j in range(1, n):
            if check_graph[i][j] == check_graph[i][j-1]:
                cnt += 1
            else:
                cnt = 1
            answer = max(answer, cnt)

        cnt = 1
        for j in range(1, n):
            if check_graph[j][i] == check_graph[j-1][i]:
                cnt += 1
            else:
                cnt = 1
            answer = max(answer, cnt)


n = int(sys.stdin.readline())
graph = [list(map(str, sys.stdin.readline().strip())) for _ in range(n)]
dx = [1, 0]
dy = [0, 1]
answer = 0

check(graph)

for x in range(n):
    for y in range(n):
        for i in range(2):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                if graph[x][y] != graph[nx][ny]:
                    graph[x][y], graph[nx][ny] = graph[nx][ny], graph[x][y]
                    check(graph)
                    graph[x][y], graph[nx][ny] = graph[nx][ny], graph[x][y]


print(answer)
