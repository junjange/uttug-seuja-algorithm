def solution(lottos, win_nums):
    result = []
    cnt = 0
    num = 0

    for i in lottos:
        if i == 0:
            num += 1
        elif i in win_nums:
            cnt += 1

    if cnt == 0 and num == 0:
        result.append(6)
    else:
        result.append(7 - (cnt + num))
    if cnt == 0:
        result.append(6)
    else:
        result.append(7 - (cnt))

    return result
