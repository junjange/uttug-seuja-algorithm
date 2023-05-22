import sys
from collections import defaultdict

n, m = map(int, sys.stdin.readline().split())
room_list = [str(sys.stdin.readline().strip()) for _ in range(n)]
room_dic = defaultdict(list)
for _ in range(m):
    room_name, start, end = map(str, sys.stdin.readline().split())
    room_dic[room_name].append([int(start), int(end)])

room_list.sort()
for room in room_list:
    print("Room {0}:".format(room))
    room_time = sorted(room_dic[room], key=lambda x : x[0])
    start = "09"
    answer = []
    for rt in room_time:
        if int(start) < int(rt[0]):
            answer.append([start, rt[0]])
        start = rt[1]
    if int(start) < 18:
        answer.append([start, 18])

    if not answer:
        print("Not available")
    else:
        print("{0} available:".format(len(answer)))
        for a in answer:
            print("{0}-{1}".format(a[0], a[1]))

    if room_list.index(room) != n-1:
        print("-----")
