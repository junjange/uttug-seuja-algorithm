import sys
sys.setrecursionlimit(10**6)

def find_room_number(number, rooms):
    if number not in rooms:
        rooms[number] = number+1
        return number
    
    empty_number = find_room_number(rooms[number], rooms)
    rooms[number] = empty_number+1
    return empty_number
    


def solution(k, room_number):
    answer = []
    rooms = dict()
    
    for rn in room_number:
        room = find_room_number(rn, rooms)
        answer.append(room)
    return answer
