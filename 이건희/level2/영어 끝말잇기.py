def solution(n, words):
    result = []
    cnt = 0
    word = []

    for i in words:
        cnt += 1
        if len(word) == 0:
            word.append(i)
        elif len(i) == 1:
            break
        else:
            if word[-1][-1] == i[0] and i not in word:
                word.append(i)
            else:
                break

    if len(words) == len(word):
        return [0, 0]
    elif cnt % n == 0:
        return [n, cnt // n]
    else:
        return [cnt % n, cnt // n + 1]
