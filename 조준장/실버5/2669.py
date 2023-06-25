import sys


answer = 0
graph = [[0] * 101 for _ in range(101)]
for _ in range(4):
    sx, sy, ex, ey = map(int, sys.stdin.readline().split())
    
    for i in range(sx, ex):
        for j in range(sy, ey):
            graph[i][j] = 1

for i in range(101):
    for j in range(101):
        if graph[i][j] == 1:
            answer += 1

print(answer)
