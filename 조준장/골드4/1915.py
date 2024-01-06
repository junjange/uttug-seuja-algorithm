"""
- DP
"""
import sys

n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
dp = [[0] * m for _ in range(n)]
answer = 0

for i in range(n):
    for j in range(m):
        if i == 0 or j == 0:
            dp[i][j] = graph[i][j]

        elif graph[i][j] == 0:
            continue

        else:
            dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1

        answer = max(answer, dp[i][j])

print(answer ** 2)
