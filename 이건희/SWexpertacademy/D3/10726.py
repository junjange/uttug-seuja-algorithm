T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    M = format(M, 'b')[::-1]
     
    print(f'#{test_case} ON') if M[:N] == '1' * N else print(f'#{test_case} OFF')
