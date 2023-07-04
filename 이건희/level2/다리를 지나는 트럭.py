def solution(bridge_length, weight, truck_weights):
    result = 0
    order = [0] * bridge_length
    truck = truck_weights
    sum_weight = 0
    
    while order:
        result += 1
        sum_weight -= order.pop(0)
        
        if truck:
            if sum_weight + truck[0] <= weight:
                sum_weight += truck[0]
                order.append(truck.pop(0))
            else:
                order.append(0)
                
    return result 
