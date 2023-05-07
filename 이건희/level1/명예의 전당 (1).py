def solution(k, score):
    result = []
    award = []
    for i in range(len(score)):
        award.append(score[i])
        award.sort(reverse = True)
        if len(award) < k:
            result.append(min(award))
        else:
            result.append(award[k - 1])

    return result
