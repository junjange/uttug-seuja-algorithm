def solution(today, terms, privacies):
    result = []
    term_list = {}
    today = list(map(int, today.split('.')))
    today = (today[0] * 12 + today[1]) * 28 + today[2]

    for i in terms:
        name, term = i.split(' ')
        term_list[name] = int(term) * 28 - 1

    for i in range(len(privacies)):
        day, name = privacies[i].split(' ')
        day = list(map(int, day.split('.')))
        day = (day[0] * 12 + day[1]) * 28 + day[2]
        day += term_list[name]
        if day < today:
            result.append(i + 1)
            
    return result   
