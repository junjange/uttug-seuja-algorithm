import sys
from itertools import permutations

n, m = map(int, sys.stdin.readline().split())
numbers = sorted(list(map(int, sys.stdin.readline().split())))

for p in permutations(numbers, m):
    print(*p)
