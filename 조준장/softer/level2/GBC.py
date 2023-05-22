import sys
answer = 0
n, m = map(int, sys.stdin.readline().split())
real_section = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
test_section = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
dp = [0]*100

real_start = 0
for i in range(n):
    real_length, real_speed = real_section[i]
    for real in range(real_start, real_start+real_length):
        dp[real] = real_speed
    real_start += real_length

test_start = 0
for i in range(m):
    test_length, test_speed = test_section[i]
    for test in range(test_start, test_start+test_length):
        answer= max(answer, test_speed - dp[test])
    test_start += test_length
    

print(answer)

