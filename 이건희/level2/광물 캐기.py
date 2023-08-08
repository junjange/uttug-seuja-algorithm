from collections import deque

def solution(picks, minerals):
    result = 0
    box = []
    mineral = {"diamond" : 0, "iron" : 1, "stone" : 2}
    mine = [[1, 1, 1], [5, 1, 1], [25, 5, 1]]
    minerals = minerals[:5 * sum(picks)]
    q = deque(minerals)
    
    while q:
        cnt = 0
        d, i, s = 0, 0, 0
        
        while cnt < 5:
            cnt += 1
            now = q.popleft()
            d += mine[0][mineral[now]]
            i += mine[1][mineral[now]]
            s += mine[2][mineral[now]]
            
            if not q:
                break
                
        box.append([d, i, s])
    box.sort(key = lambda x : [x[2],x[1],x[0]])
    
    for idx, j in enumerate(picks):
        for _ in range(j):
            if box:
                result += box.pop()[idx]
            else:
                break
    
    return result
