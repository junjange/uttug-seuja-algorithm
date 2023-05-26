def solution(s):
    num = 0
    cnt = 0

    while s != '1':
        num += 1
        cnt += s.count('0')
        s = s.replace('0', '')
        s = str(bin(len(s))[2:])

    return [num, cnt]
