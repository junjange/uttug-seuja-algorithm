T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    result = 'No'
     
    for i in range(1, 10):
        num = N // i
        if num * i == N and 1 <= num <= 9:
            result = 'Yes'
            break
             
    print(f'#{test_case} {result}')
