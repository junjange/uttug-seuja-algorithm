import sys

def solution(x, y):
    if y == 1:
        return x

    elif y % 2 == 0:
        a = solution(x, y / 2)
        return a * a % 10000000007
    else:
        a = solution(x, (y - 1) / 2)
        return a * a * x % 10000000007

k, p, n = map(int, sys.stdin.readline().split())
k *= solution(p, n * 10)
print(k % 10000000007)
