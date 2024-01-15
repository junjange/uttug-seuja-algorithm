"""
- dp
"""
import sys
from collections import deque


n, m = map(int, sys.stdin.readline().split())

queue = deque([[n, 0]])
visited = [False] * 100001
visited[n] = True

while queue:
    s, depth = queue.popleft()
    if s == m:
        print(depth)
        break
    else:

        if 0 <= s - 1 < 100001 and not visited[s - 1]:
            queue.append([s - 1, depth + 1])
            visited[s - 1] = True
        
        if 0 <= s * 2 < 100001 and not visited[s * 2]:
            queue.appendleft([s * 2, depth])
            visited[s * 2] = True

        if 0 <= s + 1 < 100001 and not visited[s + 1]:
            queue.append([s + 1, depth + 1])
            visited[s + 1] = True


  
