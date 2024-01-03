import sys
from collections import Counter

n = int(sys.stdin.readline())
n_card = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
m_card = list(map(int, sys.stdin.readline().split()))

answer = []
n_counter = Counter(n_card)

for i in m_card:
    answer.append(n_counter[i])

print(*answer)
