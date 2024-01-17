import sys
from collections import defaultdict

n, m = map(int, sys.stdin.readline().split())
room = [str(sys.stdin.readline().strip("\n")) for _ in range(n)]
time = [list(sys.stdin.readline().split()) for _ in range(m)]

time.sort(key=lambda x : (x[0], x[2], x[1]))
room.sort()

dic = defaultdict(list)
for r in room:
    dic[r] = []

for t in time:
    dic[t[0]].append([t[1], t[2]])

for d in dic:
    print("Room " + d + ":")
    target = "9"
    answer = []
    for start, end in dic[d]:
        if int(target) < int(start):
            answer.append(target.zfill(2) + "-" + start)
        target = end
        
    if target != "18":
        answer.append(target.zfill(2) + "-" + "18")

    if answer:
        print(str(len(answer)) + " available:")
        for a in answer:
            print(a)
    else:
        if len(dic[d]) == 0: 
            print("1 available:")
            print("09-18")
        else:
            print("Not available")
        
    
    if room[-1] != d:
        print("-----")
