import sys
from collections import Counter

s = list(map(int, sys.stdin.readline().strip()))
c = Counter(s)
zero = int(c[0] / 2)
one = int(c[1] / 2)
answer = ""

for s_item in s:
    if s_item == 0 and zero != 0:
        zero -= 1
        answer += str(s_item)

    elif s_item == 1 and one != 0:
        one -= 1

    elif s_item == 1 and one == 0:
        answer += str(s_item)


print(answer)
