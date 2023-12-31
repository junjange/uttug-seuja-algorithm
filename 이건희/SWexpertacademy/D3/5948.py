from itertools import combinations
 
T = int(input())
for test_case in range(1, T + 1):
    nums = list(map(int, input().split()))
    box = list(combinations(nums, 3))
    result = set()
    for i in box:
        result.add(sum(i))
                 
    result = sorted(result)
    print(f'#{test_case} {result[-5]}')
