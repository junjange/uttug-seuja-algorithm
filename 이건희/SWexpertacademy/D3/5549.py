T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    result = 'Even' if n % 2 == 0 else 'Odd'
    print(f'#{test_case} {result}')
