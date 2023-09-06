def solution(triangle):
    dp = [[0] * i for i in range(1, len(triangle) + 1)]
    dp[0][0] = triangle[0][0]
    
    for i in range(len(triangle)):
        for j in range(i):
            dp[i][j] = max(dp[i][j],dp[i-1][j] + triangle[i][j])
            dp[i][j+1] = dp[i-1][j] + triangle[i][j+1]
            
    return max(dp[-1])
