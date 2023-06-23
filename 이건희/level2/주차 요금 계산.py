import math

def solution(fees, records):
    result = []
    cnt = {}
    times = {}
    for i in records:
        time, num, record = i.split(' ')
        hour, minute = map(int,time.split(':'))
        time = hour * 60 + minute
        
        if record == 'IN':
            cnt[num] = time
        else:
            record_time = cnt[num]
            del cnt[num]
            
            if num in times:
                times[num] += time - record_time
            else:
                times[num] = time - record_time
                
    for i in cnt:
        if i in times:
            times[i] += 1439 - cnt[i]
        else:
            times[i] = 1439 - cnt[i]
            
    times = sorted(times.items())

    for i in times:
        if i[1] <= fees[0]:
            result.append(fees[1])
        else:
            result.append(fees[1] + math.ceil((i[1] - fees[0]) / fees[2]) * fees[3])

    return result
