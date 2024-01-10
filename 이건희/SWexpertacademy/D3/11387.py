T = int(input())
for test_case in range(1, T + 1):
    D, L, N = map(int, input().split())
    result = 0
     
    for i in range(N):
        result += D * (1 + i * L / 100)
         
    print(f'#{test_case} {int(result)}')
