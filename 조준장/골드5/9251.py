"""
- dp
"""
import sys

a = str(sys.stdin.readline())
b = str(sys.stdin.readline())
len_a = len(a)
len_b = len(b)
dp = [[0] * len_b for _ in range(len_a)]

for i in range(1, len_a):
    for j in range(1, len_b):
        if a[i - 1] == b[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

print(dp[len_a-1][len_b-1])
