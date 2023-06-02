from collections import deque

def solution(people, limit):
    cnt = 0
    weight = 0

    people = deque(sorted(people))

    while people:
        if len(people) == 1:
            cnt += 1
            break
        elif people[0] + people[-1] <= limit:
            cnt += 1
            people.pop()
            people.popleft()
        else:
            cnt += 1
            people.pop()

    return cnt
