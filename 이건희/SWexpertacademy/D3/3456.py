T = int(input())
for test_case in range(1, T + 1):
    length = list(map(int, input().split()))
     
    num = {}
    for i in length:
        if i in num:
            num[i] += 1
        else:
            num[i] = 1
             
    for k, v in num.items():
        if v % 2 == 1:
            print(f'#{test_case} {k}')
            break
