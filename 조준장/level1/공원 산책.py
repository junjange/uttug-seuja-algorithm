def solution(park, routes):
    answer = []
    a = len(park)
    b = len(park[0])
    d = {"N" : [-1, 0], "S" : [1, 0], "W" : [0, -1], "E" : [0, 1]}
    x, y = 0, 0
    
    for i in range(a):
        for j in range(b):
            if park[i][j] == "S":
                x = i
                y = j
                break
    
    for route in routes:
        tx = x
        ty = y
        
        op, n = route.split(" ")
        nx, ny = d[op]
        
        for _ in range(int(n)):
            tx += nx
            ty += ny

            if tx < 0 or tx >= a or ty < 0 or ty >= b or park[tx][ty] == "X":
                break
        else:
            x = tx
            y = ty
    
    return [x, y]
