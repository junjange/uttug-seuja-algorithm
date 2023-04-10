def solution(rows, columns, queries):
    answer = []
    graph = []
    cnt = 1
    for r in range(rows):
        temp_graph = []
        for c in range(columns):
            temp_graph.append(cnt)
            cnt += 1
        graph.append(temp_graph)
        
    for q in queries:
        sx, sy, ex, ey = q
        sx -= 1
        sy -= 1
        ex -= 1
        ey -= 1
        min_value = 1e9
        new_graph = [[0]*columns for _ in range(rows)]
        
        # 왼쪽
        for x in range(sx, ex):
            new_graph[x][sy] = graph[x+1][sy] 
            min_value = min(min_value, graph[x+1][sy])
        
        # 아래
        for y in range(sy, ey):
            new_graph[ex][y] = graph[ex][y+1] 
            min_value = min(min_value, graph[ex][y+1])

        # 오른쪽
        for x in range(sx, ex):
            new_graph[x+1][ey] = graph[x][ey] 
            min_value = min(min_value, graph[x][ey])
        
        # 위
        for y in range(sy, ey):
            new_graph[sx][y+1] = graph[sx][y] 
            min_value = min(min_value, graph[sx][y])

        for i in range(rows):
            for j in range(columns):
                if new_graph[i][j] != 0:
                    graph[i][j] = new_graph[i][j]

        answer.append(min_value)
    
    return answer  
