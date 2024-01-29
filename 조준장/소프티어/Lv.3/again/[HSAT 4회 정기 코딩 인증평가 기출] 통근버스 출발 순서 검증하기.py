import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))

answer = 0
for i in range(n):
    cnt = 0
    for j in range(i + 1, n):
        if a[i] < a[j]:
            cnt += 1
        else:
            answer += cnt
print(answer)
