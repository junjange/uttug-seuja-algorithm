import sys


n = int(sys.stdin.readline())
graph = [[0, 0, 0, 0]]+ [list(map(int, sys.stdin.readline().split())) for _ in range(n-1)]


a = [0] * n
b = [0] * n

for i in range(1, n):
    a[i] = min(a[i - 1] + graph[i][0], b[i - 1] + graph[i][1] + graph[i][3])
    b[i] = min(b[i - 1] + graph[i][1], a[i - 1] + graph[i][0] + graph[i][2])

last_a, last_b = map(int, sys.stdin.readline().split())
a[n - 1] += last_a
b[n - 1] += last_b

print(min(a[n - 1], b[n - 1]))
