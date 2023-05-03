def solution(sizes):
    mn = 0
    nn = 0
    for i in range(len(sizes)):
        if mn < max(sizes[i]):
            mn = max(sizes[i])
        if nn < min(sizes[i]):
            nn = min(sizes[i])

    return mn * nn
