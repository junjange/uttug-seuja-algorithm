import sys

n = int(sys.stdin.readline())
x = list(map(int, sys.stdin.readline().split()))
new_x = sorted(list(set(x)))

dic = {new_x[i]: i for i in range(len(new_x))}

for i in x:
    print(dic[i], end=" ")
