import sys
from collections import Counter
from collections import defaultdict

for _ in range(int(sys.stdin.readline())):
    answer = [-1, [1e9]]
    n = int(sys.stdin.readline())
    m = list(map(int, sys.stdin.readline().split()))
    m_count = Counter(m)
    dic = defaultdict(list)
    rank = 1
    for i in range(n):
        if m_count[m[i]] == 6:
            dic[m[i]].append(rank)
            rank += 1

    for key, value in dic.items():
        if sum(answer[1][:4]) == sum(value[:4]):
            if answer[1][4] > value[4]:
                answer[0] = key
                answer[1] = value

        elif sum(answer[1][:4]) > sum(value[:4]):
            answer[0] = key
            answer[1] = value

    print(answer[0])
