"""
톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.
톱니바퀴가 회전할 때 맞닿는 부분의 극이 다르고 회전 했다면 회전 시킨다.
"""

import sys
from collections import deque


def right_rotate(start, dirs):
    if start < 4 and gear[start-1][2] != gear[start][6]:
        right_rotate(start+1, -dirs)
        gear[start].rotate(dirs)


def left_rotate(start, dirs):
    if start >= 0 and gear[start+1][6] != gear[start][2]:
        left_rotate(start-1, -dirs)
        gear[start].rotate(dirs)


gear = [deque(list(map(int, sys.stdin.readline().strip()))) for _ in range(4)]
k = int(sys.stdin.readline())
answer = 0

for i in range(k):
    num, dirs = map(int, sys.stdin.readline().split())

    left_rotate(num-2, -dirs)
    right_rotate(num, -dirs)
    gear[num-1].rotate(dirs)

if gear[0][0]:
    answer += 1
if gear[1][0]:
    answer += 2
if gear[2][0]:
    answer += 4
if gear[3][0]:
    answer += 8

print(answer)
