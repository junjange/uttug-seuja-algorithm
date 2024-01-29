import sys
import bisect

n, q = map(int, sys.stdin.readline().split())
cars = sorted(list(map(int, sys.stdin.readline().split())))

for _ in range(q):
    m = int(sys.stdin.readline()) 
    index = bisect.bisect_left(cars, m)
    
    if index < n and cars[index] == m:
        print(index * (n - index - 1))
    else:
        print(0)
    
