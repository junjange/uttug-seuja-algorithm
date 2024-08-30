N = 1000000
nums = []
 
for i in range(2, N):
    for j in range(2, int(i ** 0.5) + 1):
        if i % j == 0:
            break
    else:
        nums.append(str(i))
 
result = ' '.join(nums)
print(result)
