for test_case in range(1, 11):
    N, num = map(int, input().split())
    num = list(str(num))
    result = []
     
    for i in num:
        if not result or i != result[-1]:
            result.append(i)
        elif result and i == result[-1]:
            result.pop()
             
    print(f'#{test_case} {int("".join(map(str, result)))}')
