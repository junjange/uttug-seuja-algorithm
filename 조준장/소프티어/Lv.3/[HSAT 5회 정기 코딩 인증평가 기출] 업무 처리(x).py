import sys
from collections import deque

h, k, r = map(int, sys.stdin.readline().split())
works = [deque(list(map(int, sys.stdin.readline().split()))) for _ in range(2 ** h)]
organization = [deque() for _ in range(2 **(h + 1))] 

for i in range(len(works)):
    organization[2 ** (h + 1) - 1 - i] = works[-i - 1] 

answer = 0
for day in range(r):
    for i in range(1, 2 ** h):
        if i == 1:
            if organization[i]:
                answer += organization[i].popleft()
                
        if day % 2 == 0:
            if organization[i * 2 + 1]:
                organization[i].append(organization[i * 2 + 1].popleft())
        else:
            if organization[i * 2]:
                organization[i].append(organization[i * 2].popleft())
            
print(answer)   
