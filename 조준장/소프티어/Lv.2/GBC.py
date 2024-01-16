import sys

n, m = map(int, sys.stdin.readline().split())
real = []

for _ in range(n):
    r, l = map(int, sys.stdin.readline().split())
    for _ in range(r):
        real.append(l)

start = 0
for _ in range(m):
    r, l = map(int, sys.stdin.readline().split())
    for i in range(start, start + r):
        real[i] -= l
    start += r
        
answer = -min(real)
if answer < 0:
    print(0)
else:
    print(answer)
