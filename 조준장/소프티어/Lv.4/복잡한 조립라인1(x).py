import sys

k, n = list(map(int, sys.stdin.readline().split()))
table = [[[0 for _ in range(k)] for _ in range(k)] for _ in range(n)]
dp = []

for i in range(n - 1):
    line = list(map(int, sys.stdin.readline().split()))
    dp.append(line[:k])
    t = 0

    for j in range(k):
        for l in range(k):
            if j != l:
                table[i][j][l] = line[k + t]
                t += 1

dp.append(list(map(int, sys.stdin.readline().split())))
            

for i in range(n - 1):
    for j in range(k):
        time = dp[i][j]
        for l in range(k):
            if j != l:
                time = min(time, dp[i][l] + table[i][l][j])
            
        dp[i+1][j] += time

print(min(dp[n-1]))
