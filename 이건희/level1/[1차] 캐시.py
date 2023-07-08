def solution(cacheSize, cities):
    result = 0
    cache = []
    
    for i in cities:
        i = i.lower()
        if not i in cache:
            result += 5
            if len(cache) < cacheSize:
                cache.append(i)
            else:
                cache.append(i)
                cache.pop(0)
        else:
            result += 1
            cache.remove(i)
            cache.append(i)
            
    return result
