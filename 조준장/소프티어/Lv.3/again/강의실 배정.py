import sys
import heapq

n = int(sys.stdin.readline())
heap = []
for _ in range(n):
    s, f = map(int, sys.stdin.readline().split())
    heapq.heappush(heap, (f, s))
answer = 0

pre_f = 0
while heap:

    nf, ns = heapq.heappop(heap)

    if pre_f <= ns:
        pre_f = nf
        answer += 1
print(answer)
        
    
