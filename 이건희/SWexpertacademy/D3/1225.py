for test_case in range(1, 11):
    n = int(input())
    nums = list(map(int, input().split()))
    i = 1
     
    while True:
        num = nums.pop(0)
        num = max(0, num - i)
        nums.append(num)
        if num == 0:
            break
        i += 1
        if i > 5:
            i = 1
             
    print(f'#{test_case} {" ".join(map(str, nums))}')
