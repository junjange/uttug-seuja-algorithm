def solution(money):
    dp1 = [0 for _ in range(len(money))]
    dp2 = dp1.copy()
    dp1[:2] = [money[0], max(money[:2])]
    dp2[:2] = [0, money[1]]
    
    for i in range(2, len(money) - 1):
        dp1[i] = max(dp1[i - 2] + money[i], dp1[i - 1])
        
    for i in range(2, len(money)):
        dp2[i] = max(dp2[i - 2] + money[i], dp2[i - 1])

    return max(max(dp1), max(dp2))
