import sys
import heapq

n = int(sys.stdin.readline())
heap = []
for _ in range(n):
    s, f = map(int, sys.stdin.readline().split())
    heapq.heappush(heap, (f, s))
    
answer = 0
end_time = 0
while heap:
    f, s = heapq.heappop(heap)

    if end_time <= s:
        end_time = f
        answer += 1

print(answer)
