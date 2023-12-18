"""
- 수열의 맨 뒤부터 확인 -> x
- 반복문을 통해 오큰수를 찾는다.
"""

import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
stack = [0]
answer = [-1] * n

for i in range(1, n):
    while stack and a[stack[-1]] < a[i]:
        answer[stack.pop()] = a[i]

    stack.append(i)


print(*answer)
