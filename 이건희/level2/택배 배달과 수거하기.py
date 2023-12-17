from collections import deque

def solution(cap, n, deliveries, pickups):
    result = 0
    deliver = deque()
    pick = deque()
    cntD = []
    cntP = []
    
    for i in range(n - 1, -1, -1):
        if deliveries[i] != 0:
            deliver.append([i + 1, deliveries[i]])
        if pickups[i] != 0:
            pick.append([i + 1, pickups[i]])
            
    capD, capP = cap, cap
    
    while deliver:
        num, cnt = deliver.popleft()
        if capD == cap:
            cntD.append(num)
        if capD >= cnt:
            capD -= cnt
        else:
            cnt -= capD
            capD = cap
            deliver.appendleft([num, cnt])
            
    while pick:
        num, cnt = pick.popleft()
        if capP == cap:
            cntP.append(num)
        if capP >= cnt:
            capP -= cnt
        else:
            cnt -= capP
            capP = cap
            pick.appendleft([num, cnt])
            
    max_length = max(len(cntD), len(cntP))
    cntD.extend([0] * (max_length - len(cntD)))
    cntP.extend([0] * (max_length - len(cntP)))
    
    for i in range(max_length):
        maxNum = max(cntD[i], cntP[i])
        result += maxNum
        
    return result * 2
