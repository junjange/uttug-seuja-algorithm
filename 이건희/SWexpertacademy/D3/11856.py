T = int(input())
for test_case in range(1, T + 1):
    S = input()
    result = 'Yes' if len(list(set(S))) == 2 else 'No'
    print(f'#{test_case} {result}')
