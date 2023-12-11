T = int(input())
for test_case in range(1, T + 1):
    S = input()
    result = S.count('(') + S.count(')') - S.count('()')
    print(f'#{test_case} {result}')
