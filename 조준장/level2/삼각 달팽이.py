def solution(n):
    answer = []
    graph = []

    graph = [[0 for j in range(i)] for i in range(1, n+1)] # 삼각형 구조 만들기

    x = -1
    y = 0
    num = 0
    for v in range(n):
        for s in range(v, n):
            if v % 3 == 0:
                x += 1
                
            elif v % 3 == 1:
                y += 1
                
            else:
                x -= 1
                y -= 1
                
            num += 1
            graph[x][y] = num
                
    for g in graph:
        answer += g
        
    return answer
