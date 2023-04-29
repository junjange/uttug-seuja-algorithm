def solution(n, stations, w):
    answer = 0
    station_len = (w * 2) + 1
    start = 1
    
    for station in stations:
        num = station - w - start - 1
        x, y = divmod(num, station_len)
        if x == 0:
            answer += 1
        else:
            answer += x+1
        
        start = station+w+1
    
    if start <= n:
        num = n - start
        x, y = divmod(num, station_len)
        if x == 0:
            answer += 1
        else:
            answer += x+1
        
        
    return answer
