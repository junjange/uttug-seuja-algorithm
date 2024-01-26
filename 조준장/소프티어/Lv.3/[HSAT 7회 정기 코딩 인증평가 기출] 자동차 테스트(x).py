import sys
from bisect import bisect_left

n, q = map(int, sys.stdin.readline().split())
cars = sorted(list(map(int, sys.stdin.readline().split())))

for _ in range(q):
    m = int(sys.stdin.readline())
    
    bl = bisect_left(cars, m)
    if bl < n and m == cars[bl]:
        print(bl * (n - bl - 1))
    else:
        print(0)
        
    
    
