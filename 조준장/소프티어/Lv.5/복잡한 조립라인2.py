import sys


k, n = map(int, sys.stdin.readline().split())
table = []
dp = []
for i in range(n-1):
    l = list(map(int, sys.stdin.readline().split()))
    dp.append(l[:k])
    table.append(l[-1])

dp.append(list(map(int, sys.stdin.readline().split())))
for i in range(n - 1):
    temp = min(dp[i])

    for j in range(k):
        if i == j:
            dp[i + 1][j] += dp[i][j]
        else:
            dp[i + 1][j] += min(dp[i][j], temp + table[i])

print(min(dp[-1]))
