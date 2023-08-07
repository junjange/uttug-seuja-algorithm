def solution(book_time):
    result = []
    book_time = sorted(book_time, key=lambda x: (x[0], x[1]))
    
    for i in book_time:
        time = []
        for j in i:
            hour, minute = map(int, j.split(':'))
            time.append(hour * 60 + minute)
            
        for j in range(len(result)):
            if result[j] <= time[0]:
                result[j] = time[1] + 10
                break
        else:
            result.append(time[1] + 10)
        result.sort()
        
    return len(result)
