"""
- 누적합
"""
import sys

n, m = map(int, sys.stdin.readline().split())
nums = [0] + list(map(int, sys.stdin.readline().split()))

for i in range(1, n + 1):
    nums[i] += nums[i - 1]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    print(nums[b] - nums[a - 1])
