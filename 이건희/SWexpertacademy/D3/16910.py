T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    result = 0
    num = N ** 2
     
    for i in range(-N, N + 1):
        for j in range(-N, N + 1):
            if i ** 2 + j ** 2<= num:
                result += 1
                 
    print(f'#{test_case} {result}')
