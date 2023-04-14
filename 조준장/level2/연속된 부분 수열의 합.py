def solution(sequence, k):
    answer = []
    n = len(sequence)
    end = 0
    sum_sequence = 0
    for start in range(n):
        while sum_sequence < k and end < n:
            sum_sequence += sequence[end]
            end += 1
        
        if sum_sequence == k:
            answer.append([end - start, [start, end-1]])
        sum_sequence -= sequence[start]
        
    
    answer.sort(key=lambda x :(x[0],x[1]))
    return answer[0][1]
