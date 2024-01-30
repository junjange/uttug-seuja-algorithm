import sys

n = int(sys.stdin.readline())
f = sorted(list(map(int, sys.stdin.readline().split())))
answer = -1000000
for i in range(1, n):
    answer = max(answer, f[i - 1] * f[i])

print(answer)
