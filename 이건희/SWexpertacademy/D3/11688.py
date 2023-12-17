import math
 
T = int(input())
for test_case in range(1, T + 1):
    word = input()
    a, b = 1, 1
     
    for i in word:
        if i == 'L':
            b += a
        else:
            a += b
             
    gcd=math.gcd(a,b)
     
    print(f'#{test_case} {a // gcd} {b // gcd}')
