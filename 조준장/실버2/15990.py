"""
- 점화식을 통해 풀이
"""
import sys

t = int(sys.stdin.readline())

dp = [[0] * 3 for _ in range(100001)]
dp[1] = [1, 0, 0]
dp[2] = [0, 1, 0]
dp[3] = [1, 1, 1]

for i in range(4, 100001):
    dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 1_000_000_009
    dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % 1_000_000_009
    dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % 1_000_000_009

for _ in range(t):
    n = int(sys.stdin.readline())

    print(sum(dp[n]) % 1_000_000_009)
