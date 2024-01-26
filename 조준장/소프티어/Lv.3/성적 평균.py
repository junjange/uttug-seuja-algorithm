import sys

n, k = map(int, sys.stdin.readline().split())
s = list(map(int, sys.stdin.readline().split()))
ab = [list(map(int, sys.stdin.readline().split())) for _ in range(k)]
dp = [0] * n
dp[0] = s[0]

for i in range(1, n):
    dp[i] += dp[i-1] + s[i]


for a, b in ab:
    print(f"{(dp[b-1] - dp[a-1] + s[a-1]) / (b - a + 1):.2f}")
