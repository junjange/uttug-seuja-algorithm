def solution(s):
    words = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    for i, num in enumerate(words):
        s = s.replace(num, str(i))
    return int(s)
