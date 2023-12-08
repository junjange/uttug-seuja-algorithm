T = int(input())
for test_case in range(1, T + 1):
    TC = int(input())
    result = 'Alice' if TC % 2 == 0 else 'Bob'
     
    print(f'#{test_case} {result}')
