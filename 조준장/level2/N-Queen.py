# 대각선의 퀸이 있는지 확인
def check(graph, x):
    for i in range(x):
        if abs(graph[x] - graph[i]) == x - i:
            return False
    return True
        
def backtracking(graph, visited, queen, n):
    global answer
    if n == queen:
        answer += 1
        return 
        
    for i in range(n):
        if not visited[i]:
            graph[queen] = i
                
            if check(graph, queen):
                visited[i] = True
                backtracking(graph, visited, queen+1, n)
                visited[i] = False
            else:
                graph[queen] = 0
                    
answer = 0

def solution(n):
    graph = [0 for _ in range(n)]
    visited = [False for _ in range(n)]
    backtracking(graph, visited, 0, n)
    
    return answer
