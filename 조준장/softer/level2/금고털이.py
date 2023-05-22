import sys

answer = 0
w, n = map(int, sys.stdin.readline().split())
mp = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

mp.sort(reverse=True, key=lambda x: x[1])

for i in range(len(mp)):
    m, p = mp[i]

    if w >= m:
        w-= m
        answer += m*p
    else:
        answer += w * p
        break
print(answer)
