def solution(wallpaper):
    result = []
    start = [50, 50]
    end = [0, 0]
    
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == '.':
                pass
            else:
                if start[0] > i or start[1] > j:
                    start = [min(start[0], i), min(start[1], j)]
                if end[0] <= i + 1 or end[1] <= j + 1:
                    end = [max(end[0], i + 1), max(end[1], j + 1)]
            
    return [start[0], start[1], end[0], end[1]]
            
