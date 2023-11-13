T = 10
for test_case in range(1, T + 1):
    N = int(input())
    pw = list(map(int, input().split()))
    M = int(input())
    commands = list(input().split())
     
    for i in range(len(commands)):
        if commands[i] == "I":
            idx = int(commands[i+1])
            cnt = int(commands[i+2])
            for j in range(cnt):
                pw.insert(idx+j,int(commands[i+3+j]))
        elif commands[i] == "D":
            idx = int(commands[i+1])
            cnt = int(commands[i+2])
            for j in range(cnt):
                del pw[idx]
        elif commands[i] == "A":
            cnt = int(commands[i+1])
            for j in range(1,cnt+1):
                pw.append(int(commands[i+j+1]))
             
    print(f'#{test_case} {" ".join(map(str,pw[:10]))}')
