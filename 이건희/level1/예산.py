def solution(d, budget):
    d.sort()
    cnt = 0
    result = 0
    for i in d:
        if result + i <= budget:
            result += i
            cnt += 1

    return cnt
