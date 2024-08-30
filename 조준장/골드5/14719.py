import sys

h, w = map(int, sys.stdin.readline().split(" "))
bloc_h = list(map(int, sys.stdin.readline().split(" ")))
answer = 0

for i in range(1, w - 1):
    left = max(bloc_h[:i])
    right = max(bloc_h[i + 1:])

    compare = min(left, right)

    if bloc_h[i] < compare:
        answer += compare - bloc_h[i]

print(answer)
