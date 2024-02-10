import sys
from collections import defaultdict


n = int(sys.stdin.readline())
dic = defaultdict(int)

for _ in range(n):
    k = int(sys.stdin.readline())
    dic[k] = 1

for i in range(-1000001, 1000001):
    if dic[i] == 1:
        print(i)
