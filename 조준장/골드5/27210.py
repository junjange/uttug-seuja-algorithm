import sys

n = int(sys.stdin.readline())
m = list(map(int, sys.stdin.readline().split()))
p = 0
answer = 0

for i in range(n):
    if m[i] == 1:
        p += 1
    else:
        p -= 1

    if p < 0:
        p = 0
    answer = max(answer, p)

p = 0

for i in range(n):
    if m[i] == 2:
        p += 1
    else:
        p -= 1

    if p < 0:
        p = 0
    answer = max(answer, p)
print(answer)
