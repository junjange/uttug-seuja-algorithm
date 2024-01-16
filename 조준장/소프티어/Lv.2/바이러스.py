import sys

k, p, n = map(int, sys.stdin.readline().split())
dp = [0] * (n + 1)
dp[0] = k

for i in range(1, n + 1):
    dp[i] = dp[i-1] * p % 1000000007

print(dp[n] % 1000000007)
