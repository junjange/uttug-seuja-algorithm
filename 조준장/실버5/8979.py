import sys

n, k = map(int, sys.stdin.readline().split())
nations = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
nations.sort(reverse=True, key=lambda x: (x[1], x[2], x[3]))
answer = []
target = [0, 0, 0]
cnt = 0
idx = 0

for i in range(len(nations)):
    if k == nations[i][0]:
        idx = i

    cnt += 1
    if nations[i][1::] != target:
        target = nations[i][1::]
        answer.append(cnt)
    else:
        answer.append(answer[-1])

print(answer[idx])
