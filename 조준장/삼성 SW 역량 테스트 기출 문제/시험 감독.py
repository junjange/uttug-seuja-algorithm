import sys


n = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
b, c = map(int, sys.stdin.readline().split())

answer = 0
for a in A:
    a -= b
    answer += 1
    if a < 0:
        continue
    x, y = divmod(a, c)
    answer += x
    if y:
        answer += 1

print(answer)
