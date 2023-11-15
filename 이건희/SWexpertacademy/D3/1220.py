T = 10
for test_case in range(1, T + 1):
    num = int(input())
    magnetics = []
    result = 0
    for i in range(100):
        magnetic = list(map(int, input().split()))
        magnetics.append(magnetic)
         
    for i in range(100):
        word = ''
        for j in range(100):
            if magnetics[j][i] == 1 or magnetics[j][i] == 2:
                word += str(magnetics[j][i])
                 
        result += word.count('12')
         
    print(f'#{test_case} {result}')
