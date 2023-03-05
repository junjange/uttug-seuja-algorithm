import sys

n = int(sys.stdin.readline())
ts = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
ts.sort(reverse=True, key=lambda x: x[1])
time = ts[0][1] - ts[0][0]

for i in range(1, len(ts)):
    t, s = ts[i]

    if time > s:
        time = s - t
    else:
        time -= t

print(time if time >= 0 else -1)
