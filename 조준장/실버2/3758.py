import sys

case = int(sys.stdin.readline())

for _ in range(case):
    n, k, t, l = map(int, sys.stdin.readline().split())
    score = [[0 for _ in range(k)] for _ in range(n)]
    submit = [0 for _ in range(n)]
    time = [0 for _ in range(n)]

    for k in range(l):
        i, j, s = map(int, sys.stdin.readline().split())
        score[i - 1][j - 1] = max(score[i - 1][j - 1], s)
        submit[i - 1] += 1
        time[i - 1] = k

    line = []

    for h in range(n):
        line.append([sum(score[h]), submit[h], time[h], h])

    line.sort(key=lambda x: (-x[0], x[1], x[2]))

    for rank in range(n):
        if line[rank][3] == t - 1:
            print(rank + 1)
