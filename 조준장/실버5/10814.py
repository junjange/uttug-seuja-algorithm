import sys

n = int(sys.stdin.readline())
m = []
for i in range(n):
    old, name = map(str, sys.stdin.readline().split())
    m.append([i, int(old), name])


m.sort(key=lambda x: (x[1], x[0]))

for i in m:
    print(i[1], i[2])
