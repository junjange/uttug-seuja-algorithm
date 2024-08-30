T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
     
    for i in range(int(N ** 0.5) + 1 , 0, -1):
        if N % i == 0:
            result = i + N // i - 2
            print(f'#{test_case} {result}')
            break
