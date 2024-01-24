import sys
from collections import defaultdict

n, b = map(int, sys.stdin.readline().split())
performance = list(map(int, sys.stdin.readline().split()))
dic_performance = defaultdict(int)
performance.sort(reverse = True)

for p in performance:
    dic_performance[p] += 1

left = performance[-1]
right = 2000000000

while right - left - 1 > 0:
    mid = (left + right) // 2
    cost = 0
    flag = False
    
    for k, v in dic_performance.items():
        if k < mid:
            cost += ((mid - k) ** 2) * v
        
            if cost > b:
                right = mid
                flag = True
                break
                
    if not flag:
        left = mid
        
print(left)
