import sys

p, n = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))

dp = [0] * n
dp[0] = a[0]
for i in range(1, n):
    dp[i] = (dp[i - 1] * p + a[i]) % 1000000007

print(dp[n-1] % 1000000007)
