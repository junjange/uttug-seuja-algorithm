import sys

bulb = {'x' : [0, 0, 0 ,0, 0, 0, 0],'0' : [1, 1, 1 ,1, 1, 0, 1], '1' : [0, 1, 1 ,0, 0, 0, 0], '2' : [1, 1, 0 ,1, 1, 1, 0],
       '3' : [1, 1, 1 ,1, 0, 1, 0], '4' : [0, 1, 1 ,0, 0, 1, 1], '5' : [1, 0, 1 ,1, 0, 1, 1], 
        '6' : [1, 0, 1 ,1, 1, 1, 1], '7' : [1, 1, 1 ,0, 0, 0, 1], '8' : [1, 1, 1 ,1, 1, 1, 1],
       '9' : [1, 1, 1 ,1, 0, 1, 1]}


t = int(sys.stdin.readline())
for _ in range(t):
    answer = 0
    a, b = map(str, sys.stdin.readline().split())
    a = a.rjust(5, "x")
    b = b.rjust(5, "x")

    
    for i in range(5):
        if a[i] == b[i]:
            continue
        bulb_a = bulb[a[i]]
        bulb_b = bulb[b[i]]
        for j in range(7):
            if bulb_a[j] != bulb_b[j]:
                answer += 1
                
    print(answer)
            
