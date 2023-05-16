def solution(s, n):
    word = list(s)
    result = []
    for i in word:
        num = ord(i)
        if 65 <= num <= 90:
            num += n
            if 90 < num:
                num -= 26
        elif 97 <= num <= 122:
            num += n
            if 122 < num:
                num -= 26
        result.append(chr(num))
    return ''.join(result)
