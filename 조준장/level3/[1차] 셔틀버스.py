def solution(n, t, m, timetable):    
    times = [int(time[:2])*60 + int(time[3:]) for time in timetable ]
    times.sort()
    start_time = 540
    bus_time = [9*60 + t*i for i in range(n)]
    
    for bt in bus_time:
        cnt = 0
        while cnt < m and times and times[0] <= bt:
            cnt += 1
            end_time = times.pop(0)
            
        if cnt < m: 
            answer = bt
        # 버스에 자리가 없는 경우 맨 마지막 크루보다 1분 먼저 도착
        else: 
            answer = end_time-1

    return str(answer//60).zfill(2) + ":" + str(answer%60).zfill(2)
