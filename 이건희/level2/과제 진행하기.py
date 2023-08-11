from collections import deque

def solution(plans):
    def get_time(time):
        hour, minute = int(time[0:2]), int(time[3:5])
        return hour * 60 + minute
    
    plans =  sorted(list(map(lambda x: [x[0], get_time(x[1]), int(x[2])], plans)), key=lambda x: x[1])
    result, wait, now = [], deque([plans[0]]), plans[0][1]

    for i, k in enumerate(plans[1:]):
        time = k[1]
        
        while wait:
            n, s, p = wait.pop()
            if s > now:
                now = s
            e = now + p

            if e <= time:
                now += p
                result.append(n)
            else:
                now = time
                wait.append([n, s, e - time])
                break

        wait.append(k)
        
    while wait:
        result.append(wait.pop()[0])

    return result
