import sys
from collections import deque

n = int(sys.stdin.readline())

stack = deque([])
for _ in range(n):
    order = list(map(int, sys.stdin.readline().split()))

    if order[0] == 1:
        stack.append(order[1])
    elif order[0] == 2:
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif order[0] == 3:
        print(len(stack))
    elif order[0] == 4:
        if stack:
            print(0)
        else:
            print(1)
    else:
        if stack:
            print(stack[-1])
        else:
            print(-1)
