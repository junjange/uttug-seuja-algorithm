import sys

n = int(sys.stdin.readline())
m = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

m.sort(key=lambda x: (x[1], x[0]))

for i in m:
    print(*i)
