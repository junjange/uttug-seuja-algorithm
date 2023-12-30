T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    S = list(int(input()) for _ in range(N))
    result = 0
    avg = sum(S) // N
 
    for i in S:
        if i < avg:
            result += avg - i
             
    print(f'#{test_case} {result}')
