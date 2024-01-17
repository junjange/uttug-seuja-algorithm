import sys


def col(time):
    time = time.split(":")
    return (int(time[0]) * 60) + int(time[1])


answer = 0

for i in range(5):
    start_time, end_time = map(str, sys.stdin.readline().split())
    answer += col(end_time) - col(start_time)

print(answer)
