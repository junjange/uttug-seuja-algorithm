def solution(s):
    result = []
        
    s = s[:-2].replace('{','').replace(',',' ').split('}')
    s = [i.split() for i in s]
    s.sort(key=lambda x:len(x))
    
    for i in s:
        num = set(i) - set(result)
        result.append(list(num)[0])
    
    result = [int(i) for i in result]
    return result
