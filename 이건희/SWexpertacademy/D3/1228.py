for test_case in range(1, 11):
    N = int(input())
    pw = list(map(int, input().split()))
    M = int(input())
    commands = list(input().split())
     
    for i in range(len(commands)):
        if commands[i] == 'I':
            x, y = int(commands[i+1]), int(commands[i+2])
            for j in range(y):
                pw.insert(x + j, int(commands[i + 3 + j]))
                 
    print(f'#{test_case} {" ".join(map(str,pw[:10]))}')
