"""
- 괄호의 개수를 통해 문제를 해결
"""

import sys

input = list(map(str, sys.stdin.readline().strip()))

stack = []
answer = 0

for i in range(len(input)):
    if input[i] == "(":
        stack.append("(")
    elif input[i - 1] == ")":
        stack.pop()
        answer += 1
    else:
        stack.pop()
        answer += len(stack)

print(answer)
