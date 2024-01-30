import sys


n = int(sys.stdin.readline())
m = sorted(list(map(int, sys.stdin.readline().split())))
answer = 0

for i in range(2, 100):
    cnt = 0
    for j in range(n):
        if m[j] >= i and m[j] % i == 0:
            cnt += 1
    answer = max(answer, cnt)

print(answer)
