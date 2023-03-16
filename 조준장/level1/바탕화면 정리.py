def solution(wallpaper):
    sx, sy, ex, ey = 51, 51,-1, -1
    
    for y in range(len(wallpaper)):
        for x in range(len(wallpaper[0])):
            if wallpaper[y][x] == "#":
                sx = min(sx, x)
                sy = min(sy, y)
                ex = max(ex, x)
                ey = max(ey, y)
        
    return [sy, sx, ey+1, ex+1]
