import sys
from collections import defaultdict

n = int(sys.stdin.readline())
country = list(map(int, sys.stdin.readline().split()))

dic = defaultdict(int)

for i in range(1, n):
    dic[country[i] - country[i - 1]] += 1

print(min(dic.items())[1])
