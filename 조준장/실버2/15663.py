"""
- 순열
"""
import sys
from itertools import permutations

n, m = map(int, sys.stdin.readline().split())
numbers = list(map(int, sys.stdin.readline().split()))

for p in sorted(set(permutations(numbers, m))):
    print(*p)
