import sys
import heapq

n = int(sys.stdin.readline())
mid = int(sys.stdin.readline())
left = []
right = []
print(mid)
for _ in range(1, n):
    num = int(sys.stdin.readline())
    if num > mid:
        heapq.heappush(right, num)
        if len(left) + 1 < len(right):
            heapq.heappush(left, (-mid, mid)) # 최소 값 업데이트
            mid = heapq.heappop(right)

    else:
        heapq.heappush(left, (-num, num))
        if len(left) > len(right):
            heapq.heappush(right, mid)
            mid = heapq.heappop(left)[1]

    print(mid)

