T = int(input())
for test_case in range(1, T + 1):
    A, B = map(int, input().split())
    result = 0
    for i in range(A, B + 1):
        num = int(i**0.5)
        if i == num ** 2 and str(i) == str(i)[::-1] and str(num) == str(num)[::-1]:
            result += 1
             
    print(f'#{test_case} {result}')
