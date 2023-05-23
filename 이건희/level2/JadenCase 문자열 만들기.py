def solution(s):
    word = s.split(" ")
    result = []

    for i in word:
        word = i.lower()
        if word.isalpha():
            word = word.capitalize()
        result.append(word)

    return ' '.join(map(str, result))
