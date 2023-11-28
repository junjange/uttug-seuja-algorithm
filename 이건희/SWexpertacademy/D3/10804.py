T = int(input())
change = {'b' : 'd', 'd' : 'b', 'p' : 'q', 'q' : 'p'}
for test_case in range(1, T + 1):
    word = input()
    result = ''
     
    for i in reversed(word):
        result += change[i]
     
    print(f'#{test_case} {result}')
