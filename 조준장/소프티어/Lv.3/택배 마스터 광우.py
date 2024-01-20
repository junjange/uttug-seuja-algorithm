import sys
from itertools import permutations

n, m, k = map(int, sys.stdin.readline().split())
rail = list(map(int, sys.stdin.readline().split()))


answer = 1e9

for r in permutations(rail, len(rail)):
    new_answer = 0
    count = 0
    idx = 0
    box = 0
    while count < k:
        currnet_box = r[(idx) % n] 
        if box + currnet_box <= m:
            box += currnet_box
            idx += 1
        else:
            new_answer += box
            box = 0
            count += 1
            
    answer = min(answer, new_answer)

print(answer)


        
    
