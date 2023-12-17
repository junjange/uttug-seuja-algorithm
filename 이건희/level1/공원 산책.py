def solution(park, routes):
    result = []
    w = len(park[0])
    h = len(park)
    
    move = {"N" : [0, -1], "S" : [0, 1], "W" : [-1, 0], "E" : [1, 0]}
    
    for i in range(h):
        for j in range(w):
            if park[i][j] == "S":
                nowX = j
                nowY = i
                
    for route in routes:
        op, n = route.split(" ")
        x, y = nowX, nowY
        dX, dY = move[op]

        for _ in range(int(n)):
            x += dX
            y += dY
            
            if x < 0 or w - 1 < x or y < 0 or h - 1 < y or park[y][x] == "X":
                break
        else:
            nowX, nowY = x, y
            
    return [nowY, nowX]
