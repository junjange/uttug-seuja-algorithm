import sys
from collections import defaultdict
t = int(sys.stdin.readline())

for _ in range(t):
    w = str(sys.stdin.readline())
    k = int(sys.stdin.readline())
    dic = defaultdict(list)

    for i in range(len(w)):
        if w.count(w[i]) >= k:
            dic[w[i]].append(i)

    if not dic:
        print(-1)
    else:
        min_l = 1e9
        max_l = 0
        for d in dic:
            for j in range(len(dic[d]) - k + 1):
                length = dic[d][j + k - 1] - dic[d][j] + 1
                min_l = min(min_l, length)
                max_l = max(max_l, length)
        print(min_l, max_l)

