import sys

n = int(sys.stdin.readline())

dp = [0] * (n + 1)

dp[0] = 3

for i in range(1, n + 1):
    dp[i] = dp[i-1] + dp[i-1] - 1

print(dp[n-1] ** 2)
