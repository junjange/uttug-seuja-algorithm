import sys

a, b = map(int, sys.stdin.readline().split())
answer = a * b

while b:
    if a > b:
        a, b = b, a

    b %= a

print(answer // a)
