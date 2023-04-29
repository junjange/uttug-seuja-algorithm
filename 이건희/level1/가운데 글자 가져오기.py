def solution(s):
    s = list(s)
    result = []
    if len(s) % 2 == 0:
        result.append(s[len(s) // 2 - 1])
        result.append(s[len(s) // 2])
        return ''.join(map(str, result))
    return s[len(s) // 2]
