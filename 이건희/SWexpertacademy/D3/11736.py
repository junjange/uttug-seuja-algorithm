T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    nums = list(map(int, input().split()))
    result = 0
     
    for i in range(1, N - 1):
        now = nums[i]
        if now != max(nums[i - 1 : i + 2]) and now != min(nums[i - 1 : i + 2]):
            result += 1
             
    print(f'#{test_case} {result}')
