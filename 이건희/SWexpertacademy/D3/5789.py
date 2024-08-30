T = int(input())
for test_case in range(1, T + 1):
    N, Q = map(int, input().split())
    commands = []
    result = [0 for _ in range(N)]
     
    for i in range(Q):
        commands.append(list(map(int, input().split())))
 
    for i in range(len(commands)):
        L, R = commands[i][0] - 1, commands[i][1]
        for j in range(L, R):
            result[j] = i + 1
             
    result = ' '.join(map(str, result) )
    print(f'#{test_case} {result}')
