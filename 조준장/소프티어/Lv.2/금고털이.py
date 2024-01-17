import sys


w, n = map(int, sys.stdin.readline().split())
mp = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
mp.sort(key=lambda x : -x[1])

answer = 0

for m, p in mp:
    if w < m:
        answer += w * p
        break

    w -= m
    answer += m * p

print(answer)
    
