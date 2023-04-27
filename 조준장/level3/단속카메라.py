def solution(routes):
    answer = 0
    routes.sort(key=lambda x : x[1]) # 나간 지점을 중심으로 정렬
    camera = -30000
    for route in routes:
        
        # 나간 지점을 중심으로 정렬했기 때문에
        # 시작 지점을 비교하여 나간 지점보다 진입 지점이 크다면 새로운 cctv를 설치해야한다. 
        if camera < route[0]: 
            answer += 1
            camera = route[1]
    
    return answer
