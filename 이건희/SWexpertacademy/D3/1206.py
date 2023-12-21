for test_case in range(1, 11):
    N = int(input())
    buildings = list(map(int, input().split()))
    result = 0
     
    for i in range(2, N - 2):
        now = buildings[i]
        maxHeight = max(buildings[i - 2 :i] + buildings[i + 1 : i + 3])
        if now > maxHeight:
            result += now - maxHeight
             
    print(f'#{test_case} {result}')
