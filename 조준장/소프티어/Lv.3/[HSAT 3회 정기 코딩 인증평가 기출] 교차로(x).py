import sys
from collections import deque


n = int(sys.stdin.readline())
queues = [deque([]), deque([]), deque([]), deque([])]

for i in range(n):
    t, w = map(str, sys.stdin.readline().split())
    if w == "A":
        queues[0].append((i, int(t)))
    elif w == "B":
        queues[1].append((i, int(t)))
    elif w == "C":
        queues[2].append((i, int(t)))
    else:
        queues[3].append((i, int(t)))

answer = [-1] * n
curr_time = -1

while queues[0] or queues[1] or queues[2] or queues[3]:
    is_waiting = [0, 0, 0, 0]
    min_time = int(1e9)
    for i in range(4):
        if queues[i]:
            time = queues[i][0][1]
            min_time = min(min_time, time)
            
            if time <= curr_time:
                is_waiting[i] = 1
                
    num_waiting_cars = sum(is_waiting)
    
    if num_waiting_cars == 4:
        break
        
    if num_waiting_cars == 0:
        curr_time = min_time
        continue
        
    for i in range(4):
        if is_waiting[i] and not is_waiting[(i - 1) % 4]:
            idx, _ = queues[i].popleft()
            answer[idx] = curr_time

    curr_time += 1


for a in answer:
    print(a)
