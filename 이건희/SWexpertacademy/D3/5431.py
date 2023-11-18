T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    students = list(map(int, input().split()))
    result = [i for i in range(1, N + 1)]
     
    for i in students:
        result.remove(i)
         
    print(f'#{test_case} {" ".join(map(str, result))}')
