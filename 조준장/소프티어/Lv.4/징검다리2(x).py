import sys
import bisect

n = int(sys.stdin.readline())
h = list(map(int, sys.stdin.readline().split()))

dp_high = []
dp_low = []

answer_high = [0] * n
answer_low = [0] * n

for i in range(n):
    if len(dp_high) == 0:
        dp_high.append(h[i])
    else:
        if dp_high[-1] < h[i]:
            dp_high.append(h[i])
        else:
            index = bisect.bisect_left(dp_high, h[i])
            dp_high[index] = h[i]
            
    answer_high[i] = len(dp_high)

    if len(dp_low) == 0:
        dp_low.append(h[-1])
    else:
        if dp_low[-1] < h[- i - 1]:
            dp_low.append(h[- i - 1])
        else:
            index = bisect.bisect_left(dp_low, h[- i - 1])
            dp_low[index] = h[- i - 1]
            
    answer_low[- i - 1] = len(dp_low)

result_answer = [0 for _ in range(n)]
for i in range(n):
    result_answer[i] = answer_high[i] + answer_low[i]
    
print(max(result_answer)-1)
    
        
