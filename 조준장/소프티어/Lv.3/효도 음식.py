import sys

n = int(sys.stdin.readline())
m = list(map(int, sys.stdin.readline().split()))

if n == 3:
    print(m[0] + m[2])

else:
    dp = [0] * n
    reverse_dp = [0] * n
    dp[0] = m[0]
    reverse_dp[n-1] = m[-1]

    for i in range(1, n):
        dp[i] = max(m[i], dp[i - 1] + m[i])
        reverse_dp[n - i - 1] = max(m[n - i - 1], reverse_dp[n - i] + m[n - i - 1])

    answer = -int(1e9)
    for i in range(1, n - 1):
        first_corse = max(dp[:i])
        second_corse = max(reverse_dp[i:])

        answer = max(answer, first_corse + second_corse)

    print(answer)
