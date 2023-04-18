def solution(n):
    answer = []
    
    def hanoi(src, tgt, inter, n):
        if n == 1:
            answer.append([src, tgt])
        else:
            hanoi(src,inter,tgt,n-1) # 처음 -> 중간
            hanoi(src,tgt,inter,1) # 처음 -> 마지막
            hanoi(inter,tgt,src,n-1) # 중간 -> 마지막
            
    hanoi(1,3,2,n)
    
    return answer
