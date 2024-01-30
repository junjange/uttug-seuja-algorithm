import sys

a, b, d = map(int, sys.stdin.readline().split())

distance = 0
time = 0

while True:
    if distance + a >= 2 * d:
        time += 2 * d - distance
        break

    if distance < d and distance + a >= d:
        time += d - distance
        distance = d
        a, b = b, a
    else:
        time += a
        distance += a
        time += b
        
print(time)
        
