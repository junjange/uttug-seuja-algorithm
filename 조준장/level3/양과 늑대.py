def dfs(info, edges, visited, sheep, wolf):
    if sheep > wolf:
        answer.append(sheep)
    else:
        return
    
    for start, end in edges:
        if visited[start] and not visited[end]:
            visited[end] = True
            if info[end] == 0:
                dfs(info, edges, visited, sheep+1, wolf)
            else:
                dfs(info, edges, visited, sheep, wolf+1)
            visited[end] = False
                
answer = []
def solution(info, edges):
    visited = [False for _ in range(len(info))]
    visited[0] = True
    dfs(info, edges, visited, 1, 0)
    return max(answer)
