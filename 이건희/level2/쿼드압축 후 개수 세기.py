def solution(arr):
    result = [0, 0]
    num = len(arr)

    def quad(arr, num):
        nonlocal result

        now = arr[0][0]

        if num == 1:
            result[now] += 1
            return
        
        for i in arr:
            if i.count(now) != num:
                break
        else:
            result[now] += 1
            return
        
        num //= 2
        
        quad([i[:num] for i in arr[:num]], num)
        quad([i[num:] for i in arr[:num]], num)
        quad([i[:num] for i in arr[num:]], num)
        quad([i[num:] for i in arr[num:]], num)
        
    quad(arr, num)
    return result
