from collections import deque

def solution(queue1, queue2):
    answer = 0
    queue1_sum = sum(queue1)
    queue2_sum = sum(queue2)
    
    q1 = deque(queue1)
    q2 = deque(queue2)
    
    while queue1_sum != queue2_sum:
        if answer > len(queue1) * 4:
            return -1
        
        if queue1_sum > queue2_sum:
            target = q1.popleft()
            queue2_sum += target
            queue1_sum -= target
            q2.append(target)
        else:
            target = q2.popleft()
            queue1_sum += target
            queue2_sum -= target
            q1.append(target)
            
        answer += 1

    
    return answer
