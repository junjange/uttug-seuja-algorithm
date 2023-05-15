def solution(babbling):
    result = 0
    words = ["aya", "ye", "woo", "ma"]

    for i in babbling:
        for j in words:
            if j * 2 not in i:
                i = i.replace(j, ' ')
        if i.strip()=='': 
            result += 1

    return result
