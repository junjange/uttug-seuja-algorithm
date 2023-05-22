import sys

number = [
    [True, True, False, True, True, True, True],
    [False, True, False, True, False, False, False],
    [True, True, True, False, True, True, False],
    [True, True, True, True, True, False, False],
    [False, True, True, True, False, False, True],
    [True, False, True, True, True, False, True],
    [True, False, True, True, True, True, True],
    [True, True, False, True, False, False, True],
    [True, True, True, True, True, True, True],
    [True, True, True, True, True, False, True]
]

for _ in range(int(sys.stdin.readline())):
    answer = 0
    A, B = map(str, sys.stdin.readline().split())
    A = "xxxx" + A
    B = "xxxx" + B
    for i in range(1, 6):
        if A[-i] == B[-i]:
            continue 
        if B[-i] == "x":
            for k in range(7):
                if number[int(A[-i])][k] == True:
                    answer += 1
            continue
        if A[-i] == "x":
            for k in range(7):
                if number[int(B[-i])][k] == True:
                    answer += 1
            continue


        for k in range(7):
            if number[int(B[-i])][k] != number[int(A[-i])][k]:
                answer += 1
    print(answer)
            
