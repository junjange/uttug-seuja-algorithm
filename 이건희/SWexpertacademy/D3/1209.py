for _ in range(1, 11):
    test_case = int(input())
    result = 0
    nums = [list(map(int, input().split())) for _ in range(100)]
 
    for i in nums:
        result = max(result, sum(i))
 
    for i in range(100):
        cnt = 0
        for j in range(100):
            cnt += nums[j][i]
        result = max(result, cnt)
 
    for i in range(100):
        cnt = 0
        cnt += nums[i][i]
        result = max(result, cnt)
 
    for i in range(100):
        cnt = 0
        cnt += nums[i][99 - i]
        result = max(result, cnt)
         
    print(f'#{test_case} {result}')
