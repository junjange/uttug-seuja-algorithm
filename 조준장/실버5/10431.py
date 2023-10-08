import sys

p = int(sys.stdin.readline())
t = [list(map(int, sys.stdin.readline().split())) for  _ in range(p)]

for i in range(p):
    cnt = 0
    for j in range(1, len(t[i]) - 1):
        for k in range(j+1, len(t[i])):
            if t[i][j] > t[i][k]:
                cnt += 1
                t[i][j], t[i][k] = t[i][k], t[i][j]

    print(t[i][0], cnt)
