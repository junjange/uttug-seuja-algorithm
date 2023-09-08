from bisect import bisect_left

language = {"cpp": 0, "java": 1, "python": 2}
part = {"backend": 0, "frontend": 1}
career = {"junior": 0, "senior": 1}
food = {"chicken": 0, "pizza": 1}

def cal(query, arr_data):
    result = []

    for i in query:
        cnt = 0
        i = i.split(" ")

        lang_cond = i[0]
        part_cond = i[2]
        career_cond = i[4]
        food_cond = i[6]
        score_target = int(i[7])

        for l in range(3):
            if lang_cond == "-" or language[i[0]] == l:
                for p in range(2):
                    if part_cond == "-" or part[i[2]] == p:
                        for c in range(2):
                            if career_cond == "-" or career[i[4]] == c:
                                for f in range(2):
                                    if food_cond == "-" or food[i[6]] == f:
                                        scores = arr_data[l][p][c][f]
                                        cnt += len(scores) - bisect_left(scores, score_target)

        result.append(cnt)

    return result


def solution(info, query):
    arr_data = [[[[[] for _ in range(2)] for _ in range(2)] for _ in range(2)] for _ in range(3)]

    for i in info:
        l, p, c, f, s = i.split(" ")
        arr_data[language[l]][part[p]][career[c]][food[f]].append(int(s))

    for x in range(3):
        for y in range(2):
            for z in range(2):
                for w in range(2):
                    arr_data[x][y][z][w].sort()
    return cal(query, arr_data)
