import sys

n, g = map(str, sys.stdin.readline().split())
players = [str(sys.stdin.readline()) for _ in range(int(n))]

players = set(players)

if g == "Y":
    print(len(players))
elif g == "F":
    print(len(players) // 2)
elif g == "O":
    print(len(players) // 3)
