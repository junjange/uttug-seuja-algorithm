import sys
from itertools import combinations


n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

loc = []

for i in range(n):
    for j in range(n - 1):
        loc.append(((i, j), (i, j + 1)))
        loc.append(((j, i), (j + 1, i)))

answer = 0

combi_all = []
for r in range(1, 5):  
    combi_all.extend(combinations(loc, r))

for c in combi_all:
    size = len(c) * 2
    temp = set()
    for i in c:
        temp.add(i[0])
        temp.add(i[1])
        
    if len(temp) == size:
        cnt = 0
        for x, y in temp:
            cnt += graph[x][y]
        answer = max(answer, cnt)
            
print(answer)
        
    
