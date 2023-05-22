import sys
A, B = map(int, sys.stdin.readline().split())

if A > B:
    print("A")
elif A < B:
    print("B")
else:
    print("same")
