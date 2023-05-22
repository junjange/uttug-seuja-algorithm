import sys

answer = 0
times = [list(map(str, sys.stdin.readline().split())) for _ in range(5)]

for time in times:
    start_time= time[0].split(":")
    end_time = time[1].split(":")
    answer += (int(end_time[0]) - int(start_time[0])) * 60
    answer += int(end_time[1])- int(start_time[1])
print(answer)
