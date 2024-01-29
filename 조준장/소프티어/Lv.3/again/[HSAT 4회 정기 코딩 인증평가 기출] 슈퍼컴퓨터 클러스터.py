import sys
from collections import defaultdict

n, b = map(int, sys.stdin.readline().split())
a = sorted(list(map(int, sys.stdin.readline().split())), reverse = True)
dic_a = defaultdict(int)

for i in a:
    dic_a[i] += 1


start = a[-1]
end = 2000000000

while end - start > 1:
    mid = (start + end) // 2

    cost = 0
    flag = True

    for k, v in dic_a.items():
        if k < mid:
            cost += ((mid - k) ** 2) * v

            if cost > b:
                end = mid
                flag = False
                break

    if flag:
        start = mid

print(start)
