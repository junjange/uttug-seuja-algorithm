import sys

k, p, n = map(int, sys.stdin.readline().split())

for _ in range(n):
    k *= p % 1000000007

print(k)
