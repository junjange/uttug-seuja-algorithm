def solution(sticker):
    if len(sticker) <= 2:
        return max(sticker)

    dp1 = [0 for _ in range(len(sticker))]
    dp2 = dp1[:]
    dp1[:2] = [sticker[0], max(sticker[:2])]
    dp2[:2] = [0, sticker[1]]

    for i in range(2, len(sticker) - 1):
        dp1[i] = max(dp1[i - 2] + sticker[i], dp1[i - 1])


    for i in range(2, len(sticker)):
        dp2[i] = max(dp2[i - 2] + sticker[i], dp2[i - 1])

    return max(max(dp1), max(dp2))
