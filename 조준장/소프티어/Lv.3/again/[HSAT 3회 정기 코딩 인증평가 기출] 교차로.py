import sys
from collections import deque

n = int(sys.stdin.readline())
queues = [deque([]), deque([]), deque([]), deque([])]
answer = [-1] * n

for i in range(n):
    t, w = map(str, sys.stdin.readline().split())
    if w == "A":
        queues[0].append([i, int(t)])
    elif w == "B":
        queues[1].append([i, int(t)])
    elif w == "C":
        queues[2].append([i, int(t)])
    elif w == "D":
        queues[3].append([i, int(t)])

current_time = -1
while queues[0] or queues[1] or queues[2] or queues[3]:
    is_wating = [0, 0, 0, 0]
    min_time = int(1e9)
    
    for i in range(4):
        if queues[i]:
            nt = queues[i][0][1]
            min_time = min(min_time, nt)

            if nt <= current_time:
                is_wating[i] = 1
                
    sum_wating = sum(is_wating)
    if sum_wating == 4:
        break

    if sum_wating == 0:
        current_time = min_time
        continue

    for i in range(4):
        if is_wating[i] and not is_wating[i - 1]:
            index, _ = queues[i].popleft()
            answer[index] = current_time
    
    current_time += 1
for a in answer:
    print(a)
        
    
