import sys

n = int(sys.stdin.readline())
line = [list(map(int, sys.stdin.readline().split())) for _ in range(n-1)]
finish_a, finish_b = map(int, sys.stdin.readline().split())

line_a = 0
line_b = 0

time_a = 0
time_b = 0

for i in range(n - 1):
    line_a = min(time_a + line[i][0], time_b + line[i][1] + line[i][3])
    line_b = min(time_b + line[i][1], time_a + line[i][0] + line[i][2])

    time_a = line_a
    time_b = line_b
    
line_a += finish_a
line_b += finish_b

print(min(line_a, line_b))
    
