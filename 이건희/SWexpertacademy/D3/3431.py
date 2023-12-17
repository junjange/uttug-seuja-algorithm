T = int(input())
for test_case in range(1, T + 1):
    L, U, X = map(int, input().split())
    result = 0
    if U < X:
        result = -1
    elif L <= X and X <= U:
        result = 0
    else:
        result = L - X
    print(f'#{test_case} {result}')
