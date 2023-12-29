"""
- 정렬
"""
import sys


n = int(sys.stdin.readline())
m = [list(map(str, sys.stdin.readline().split())) for _ in range(n)]
m.sort(key=lambda x : (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for i in m:
    print(i[0])
