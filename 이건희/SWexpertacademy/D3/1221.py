T = int(input())
wordChange = {"ZRO" : 0, "ONE" : 1, "TWO" : 2, "THR" : 3, "FOR" : 4, "FIV" : 5, "SIX" : 6, "SVN" : 7, "EGT" : 8, "NIN" : 9}
numChange = {0 : "ZRO", 1 : "ONE", 2 : "TWO", 3 : "THR", 4 : "FOR", 5 : "FIV", 6 : "SIX", 7 : "SVN",  8 : "EGT", 9 : "NIN"}
 
for _ in range(1, T + 1):
    test_case, N = map(str, input().split())
    nums = list(input().split())
     
    for i in range(int(N)):
        nums[i] = wordChange[nums[i]]
         
    nums.sort()
     
    for i in range(int(N)):
        nums[i] = numChange[nums[i]]
         
    print(f'{test_case}')
    print(' '.join(nums))
