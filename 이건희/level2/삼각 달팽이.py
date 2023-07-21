DIRS = {0: (1, 0), 1: (0, 1), 2: (-1, -1)}

def solution(n):
    result = []
    triangle = [[0] * i for i in range(1, n + 1)]
    x, y, num = -1, 0, 1
    
    for i in range(n):
        for _ in range(i, n):
            dx, dy = DIRS[i % 3]
            x, y = x + dx, y + dy
            triangle[x][y] = num
            num += 1

    return sum(triangle, [])
