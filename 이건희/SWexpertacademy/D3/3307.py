import bisect
 
T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    nums = list(map(int, input().split()))
    dp = [nums[0]]
 
    for i in range(1, N):
        if nums[i] > dp[-1]:
            dp.append(nums[i])
        else:
            idx = bisect.bisect_left(dp, nums[i])
            dp[idx] = nums[i]
 
    print(f'#{test_case} {len(dp)}')
