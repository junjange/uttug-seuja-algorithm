def solution(n, times):
    answer = 0
    times.sort()
    max_time = times[0] * n
    min_time = times[0]
    
    while min_time != max_time-1:
        mid_time = (min_time + max_time) // 2
        cnt = 0
        for time in times:
            cnt += mid_time // time
        
        if cnt >= n:
            max_time = mid_time
        else:
            min_time = mid_time
            
    return max_time
