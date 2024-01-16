import sys

def dfs(x, y):
    global cnt
    if 0 <= x < n and 0 <= y < n:
        if graph[x][y] == 1:
            cnt += 1
            graph[x][y] = 0
            dfs(x + 1, y)
            dfs(x - 1 , y)
            dfs(x, y + 1)
            dfs(x, y - 1)

n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
answer = []

for i in range(n):
    for j in range(n):
        cnt = 0
        if graph[i][j] == 1:
            dfs(i, j)
            answer.append(cnt)

print(len(answer))
for a in sorted(answer):
    print(a)

