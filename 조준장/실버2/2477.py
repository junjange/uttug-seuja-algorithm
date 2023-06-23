import sys

k = int(sys.stdin.readline())
s = []
width = []
height = []
temp = []

answer = 0
for _ in range(6):
    d, l = map(int, sys.stdin.readline().split())
    s.append([d, l])

    if d == 1 or d == 2:
        width.append(l)
    else:
        height.append(l)


for i in range(6):
    if s[i][0] == s[(i+2)%6][0]:
        temp.append(s[(i+1)%6][1])


print((max(width) * max(height) - temp[0] * temp[1]) * k)
