T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    result = ['1/' + str(N) for _ in range(N)]
    print(f'#{test_case} {" ".join(result)}')
