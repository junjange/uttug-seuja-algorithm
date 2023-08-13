def collection(pickups, cap):
    while pickups and cap > 0:
        pickup = pickups.pop()
        if pickup <= cap :
            cap -= pickup
        else:
            pickups.append(pickup - cap)
            break


def delivery(deliveries, cap):
    while deliveries and cap > 0:
        deliverie = deliveries.pop()
        if deliverie <= cap :
            cap -= deliverie
        else :
            deliveries.append(deliverie - cap)
            break
                
def solution(cap, n, deliveries, pickups):
    answer = 0
    while deliveries or pickups :
        while deliveries and deliveries[-1] == 0 :
            deliveries.pop()
        while pickups and pickups[-1] == 0:
            pickups.pop()
            
        answer += max(len(deliveries), len(pickups))*2
        
        delivery(deliveries, cap)
        collection(pickups, cap)
        
        
    return answer
