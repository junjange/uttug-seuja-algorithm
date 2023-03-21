import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
a = deque(list(map(int, sys.stdin.readline().split())))
robot = deque([0] * n)
cnt = 0

while True:
    a.rotate(1)
    robot.rotate(1)
    robot[-1] = 0
    cnt += 1
    for i in range(n-2, -1, -1):
        if robot[i] == 1 and robot[i+1] == 0 and a[i+1] >= 1:
            robot[i] = 0
            robot[i+1] = 1
            a[i+1] -= 1

    robot[-1] = 0
    if robot[0] == 0 and a[0] >= 1:
        robot[0] = 1
        a[0] -= 1

    if a.count(0) >= k:
        break

print(cnt)

