"""
- 점화식을 통해 풀이
"""
import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))

dp = [1] * n

for i in range(n):
    for j in range(i):
        if a[i] > a[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))

target = max(dp)
answer = []
for i in range(-1, -n-1, -1):
    if target == dp[i]:
        answer.append(a[i])
        target -= 1
answer.reverse()
print(*answer)
