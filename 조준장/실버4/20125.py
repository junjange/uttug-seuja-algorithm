import sys

n = int(sys.stdin.readline())
graph = [list(map(str, sys.stdin.readline().strip())) for _ in range(n)]
answer = []
x, y = 0, 0

for i in range(n):
    cnt = 0
    for j in range(n):
        if graph[i][j] == "*":
            cnt += 1

    if cnt >= 3:
        x = i
        break

for k in range(n):
    if graph[x+1][k] == "*":
        y = k
        break

cnt = 0
for i in range(y-n-1, -n-1, -1):
    if graph[x][i] == "*":
        cnt += 1
answer.append(cnt)


cnt = 0
for i in range(y+1, n):
    if graph[x][i] == "*":
        cnt += 1
answer.append(cnt)

cnt = 0
for i in range(x+1, n):
    if graph[i][y] == "*":
        cnt += 1
answer.append(cnt)

cnt = 0
for i in range(x+1, n):
    if graph[i][y-1] == "*":
        cnt += 1
answer.append(cnt)

cnt = 0
for i in range(x+1, n):
    if graph[i][y+1] == "*":
        cnt += 1
answer.append(cnt)

print(x+1, y+1)
print(*answer)
