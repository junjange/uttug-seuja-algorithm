import sys

n = int(sys.stdin.readline())
dp = [0] * 16

for i in range(1, 16):
    dp[i] = dp[i-1] + dp[i-1]-1

print(dp[n]**2)
