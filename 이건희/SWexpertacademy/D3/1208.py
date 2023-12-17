for test_case in range(1, 11):
    num = int(input())
    box = list(map(int, input().split()))
     
    for _ in range(num):
        maxNum = box.index(max(box))
        minNum = box.index(min(box))
        box[maxNum] -= 1
        box[minNum] += 1
         
    print(f'#{test_case} {max(box) - min(box)}')
