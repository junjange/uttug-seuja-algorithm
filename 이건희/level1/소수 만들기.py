from itertools import combinations

def solution(nums):
    result = list(combinations(nums, 3))
    rslt = []

    for i in range(len(result)):
        rslt.append(result[i][0] + result[i][1] + result[i][2])

    cnt = 0

    for i in rslt:
        num = 0
        for j in range(2, i):
            if i % j == 0:
                num += 1
        if num == 0:
            cnt += 1

    return cnt
