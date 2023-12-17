T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    farm = []
    result = 0
     
    for i in range(N):
        n = input()
        farm.append(n)
     
    for i in range(len(farm)):
        num = abs(N // 2 - i)
        result += sum(map(int, farm[i][num : N - num]))
 
    print(f'#{test_case} {result}')
