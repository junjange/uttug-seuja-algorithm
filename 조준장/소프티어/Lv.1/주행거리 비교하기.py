import sys

a, b = map(int, sys.stdin.readline().split())

if a > b:
    print("A")
elif a < b:
    print("B")
else:
    print("same")
