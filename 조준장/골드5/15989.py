import sys

t = int(sys.stdin.readline())
arr = [int(sys.stdin.readline()) for _ in range(t)]
dp = [1] * 100001

for i in range(2, 10001):
    dp[i] += dp[i - 2]
for i in range(3, 10001):
    dp[i] += dp[i - 3]

for a in arr:
    print(dp[a])
