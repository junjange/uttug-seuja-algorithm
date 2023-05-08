def solution(k, m, score):
    score.sort(reverse = True)
    result = 0

    for i in range(1, len(score) // m + 1):
        result += score[i * m - 1] * m

    return result
