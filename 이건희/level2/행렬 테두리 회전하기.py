def solution(rows, columns, queries):
    result = []
    proc = []
    a = 0
    for i in range(rows):
        proc.append([a + j for j in range(1, columns + 1)])
        a += columns

    def turn_proc(x1, y1, x2, y2):
        num = proc[x1][y1]
        tmp = proc[x1][y1]

        for i in range(y1 + 1, y2 + 1):
            num = min(num, proc[x1][i])
            proc[x1][i], tmp = tmp, proc[x1][i]
            
        for i in range(x1 + 1, x2 + 1):
            num = min(num, proc[i][y2])
            proc[i][y2], tmp = tmp, proc[i][y2]
            
        for i in range(y2 - 1, y1 - 1, -1):
            num = min(num, proc[x2][i])
            proc[x2][i], tmp = tmp, proc[x2][i]
        
        for i in range(x2 - 1, x1 - 1, -1):
            num = min(num, proc[i][y1])
            proc[i][y1], tmp = tmp, proc[i][y1]
            
        return num
    
    for i in queries:
        x1, y1, x2, y2 = i[0] - 1, i[1] - 1, i[2] - 1, i[3] - 1
        result.append(turn_proc(x1, y1, x2, y2))
        
    return result
