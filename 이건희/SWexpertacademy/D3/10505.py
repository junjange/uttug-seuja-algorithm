T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    moneys = list(map(int, input().split()))
    money = sum(moneys) / N
    result = 0
     
    for i in moneys:
        if i <= money:
            result += 1
 
    print(f'#{test_case} {result}')
