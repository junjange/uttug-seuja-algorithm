from collections import deque

def solution(queue1, queue2):
    result = 0
    queue1 = deque(queue1)
    queue2 = deque(queue2)

    q1s =sum(queue1)
    q2s =sum(queue2)
    
    avg = (q1s + q2s) / 2
    lenNum = len(queue1) + len(queue2)
    
    if max(queue1) > avg or max(queue2) > avg or (q1s + q2s) % 2 == 1:
        return -1
    
    while q1s != q2s:
        if result > lenNum:
            return -1
        
        while queue2 and q1s < q2s:
            tmp = queue2.popleft()
            queue1.append(tmp)
            result += 1
            q1s += tmp
            q2s -= tmp
            
        while queue1 and q2s < q1s:
            tmp = queue1.popleft()
            queue2.append(tmp)
            result += 1
            q2s += tmp
            q1s -= tmp
            
    return result
