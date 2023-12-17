T = int(input())
for test_case in range(1, T + 1):
    word = str(input())
     
    word = word.replace('a', '').replace('e', '').replace('i', '').replace('o', '').replace('u', '')
             
    print(f'#{test_case} {word}')
