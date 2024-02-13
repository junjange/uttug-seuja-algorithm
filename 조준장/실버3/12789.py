import sys
from collections import deque

n = int(sys.stdin.readline())
m = deque(list(map(int, sys.stdin.readline().split())))

stack = deque([])

answer = 1
idx = 0
while True:
    if not stack and not m:
        break

    if stack and answer == stack[-1]:
        answer += 1
        stack.pop()
        continue

    if m and answer == m[0]:
        answer += 1
        m.popleft()
    else:
        if m:
            stack.append(m.popleft())
        else:
            break

if stack:
    print("Sad")
else:
    print("Nice")
