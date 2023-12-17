def time_to_seconds(time):
    time = time.split(":")
    return (int(time[0]) * 3600) + (int(time[1]) * 60) + int(time[2])

def seconds_to_time(seconds):
    hour = str(seconds // 3600).zfill(2)
    minute = str(seconds % 3600 // 60).zfill(2)
    second = str(seconds % 3600 % 60).zfill(2)
    return hour + ":" + minute + ":" + second
    
def solution(play_time, adv_time, logs):
    if play_time == adv_time:
        return "00:00:00"
    play_time_seconds = time_to_seconds(play_time)
    dp = [0 for _ in range(play_time_seconds+1)]
    adv_time_seconds = time_to_seconds(adv_time)
    
    for log in logs:
        log = log.split("-")
        start_time = time_to_seconds(log[0])
        end_time = time_to_seconds(log[1])
        dp[start_time] += 1
        dp[end_time] -= 1
    
    for _ in range(2):
        for i in range(1, play_time_seconds):
            dp[i] += dp[i-1]
    
    max_time = 0
    answer = ''
    for i in range(adv_time_seconds-1, play_time_seconds):
        
        time = dp[i] - dp[i-adv_time_seconds]
        
        if max_time < time:
            max_time = time
            answer = i-adv_time_seconds+1
            
    return seconds_to_time(answer)
