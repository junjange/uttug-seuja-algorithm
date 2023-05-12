def solution(a, b):
    week = ['SUN','MON','TUE','WED','THU','FRI','SAT']
    month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    day = 4
    for i in range(a - 1):
        day += month[i]
    day += b
    day %= 7
    return week[day]
