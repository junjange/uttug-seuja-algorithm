'''
1 => 1원으로 n원까지 만든다.
2 => 2원으로 n원까지 만든다.
5 => 5원으로 n원까지 만든다.    
'''
def solution(n, money):
    dp = [1] + [0] * n
    for m in money:
        for i in range(m, n+1):
            dp[i] += dp[i - m] % 1000000007
            
            
    return dp[n]
