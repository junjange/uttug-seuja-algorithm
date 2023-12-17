def solution(routes):
    result = 0
    now = -30001
    routes.sort()

    for s, e in routes:
        if s <= now:
            now = min(now, e)
        else:
            result += 1
            now = e
            
    return result
