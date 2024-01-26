import sys


def solution(n, service):
    service.sort()
    server = 0
    
    smallest = 0
    for request in service:
        if request > 300: 
            break
        smallest += 1
    
    start = smallest
    end = n-1
    
    while start <= end:
        server += 1
        
        if service[end] > 600: 
            pass
        
        elif start != end and service[start] + service[end] <= 900:
            start += 1
        
        elif smallest > 0:
            smallest -= 1
        end -= 1

    
    server += (smallest + 2) // 3

    return server
    
t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    service = list(map(int, sys.stdin.readline().split()))
    print(solution(n, service))
        
