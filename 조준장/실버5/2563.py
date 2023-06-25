import sys

n = int(sys.stdin.readline())
location = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
graph = [[False for _ in range(101)] for _ in range(101)]

for x, y in location:
    for i in range(10):
        for j in range(10):
            graph[x + i][y + j] = True


answer = 0
for i in range(101):
    for j in range(101):
        if graph[i][j]:
            answer += 1
print(answer)


