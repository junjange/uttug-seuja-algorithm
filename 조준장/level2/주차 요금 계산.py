import math

def solution(fees, records):
    car = {}
    res_car = {}
    answer_car = {}

    for r in records:
        coin = 0
        time, number, direction = r.split(" ")
        hour, minute = time.split(":")
        total_minute = (int(hour) * 60) + int(minute)
        
        if direction == "IN":
            car[number] = total_minute
        else:
            time_difference = total_minute - car[number]
            car[number] = -1
            if number not in res_car:
                res_car[number] = time_difference
            else:
                res_car[number] += time_difference

    for key, value in car.items():
        if value != -1:
            if key not in res_car:
                res_car[key] = (23*60) + 59 - value
            else:
                res_car[key] += (23*60) + 59 - value
                
    for key, value in res_car.items():
        if value <= fees[0]:
            answer_car[key] = fees[1]
            continue
        coin = fees[1]
        value -= fees[0]
        coin += math.ceil(value / fees[2]) * fees[3]
        answer_car[key] = coin
    
    return [s[1] for s in sorted(answer_car.items(), key=lambda x: x [0])]
