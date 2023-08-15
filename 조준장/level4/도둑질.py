def thievery(money):
    n = len(money)
    dp = [0 for _ in range(n)]
    dp[0] = money[0]
    dp[1] = max(money[0], money[1])
    
    flag = False
    for i in range(2, n):
        if i == n-1 and flag:
            dp[i] = dp[i-1]
            return dp
        if i == 2 and money[i] + dp[i-2] > dp[i-1]:
            flag = True
        dp[i] = max(money[i] + dp[i-2], dp[i-1])
    return dp

def solution(money):
    n = len(money)
    if n == 3:
        return max(money)

    dp = thievery(money)
    reversed_dp = thievery(list(reversed(money)))
    
    return max(dp[n-1], reversed_dp[n-1])
