answer = 1e9
fatigue = [[1,1,1],[5,1,1],[25,5,1]]
m = dict()
m["diamond"]=0
m["iron"]=1
m["stone"]=2

def dfs(idx, d, ir, s, minerals, f):
    global answer
    if idx >= len(minerals) or (not d and not ir and not s):
        answer = min(answer, f)
        return
    
    df, irf, sf = 0, 0, 0
    for i in range(idx, min(idx+5, len(minerals))):
        df += fatigue[0][m[minerals[i]]]
        irf += fatigue[1][m[minerals[i]]]
        sf += fatigue[2][m[minerals[i]]]
    
    if d:
        dfs(idx+5, d-1, ir, s, minerals, f+df)
    if ir:
        dfs(idx+5, d, ir-1, s, minerals, f+irf)
    if s:
        dfs(idx+5, d, ir, s-1, minerals, f+sf)
    

def solution(picks, minerals):
    global answer
    dfs(0, picks[0], picks[1], picks[2], minerals, 0)
    return answer


