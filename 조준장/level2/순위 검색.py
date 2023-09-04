def binary_search(graph, target):
    start = 0
    end = len(graph)
    
    while start < end:
        mid = (start + end) // 2
        
        if graph[mid] < target:
            start = mid + 1
        else:
            end = mid
            
    if graph[mid] < target: 
        return len(graph) - mid  - 1
    else: 
        return len(graph) - mid 

def find_query(query, graph):
    answer = []
    for q in query:  
        cnt = 0
        q = q.split(" ")
        
        if q[0] == "-":
            q[0] = [0, 1, 2]
        else:
            q[0] = [language_map[q[0]]]
        
        if q[2] == "-":
            q[2] = [0, 1]
        else:
            q[2] = [occupation_map[q[2]]]
        
        if q[4] == "-":
            q[4] = [0, 1]
        else:
            q[4] = [career_map[q[4]]]
            
        
        if q[6] == "-":
            q[6] = [0, 1]
        else:
            q[6] = [soul_food_map[q[6]]]
        
        for x in q[0]:
            for y in q[2]:
                for z in q[4]:
                    for a in q[6]:
                        if graph[x][y][z][a]:
                            cnt += binary_search(graph[x][y][z][a], int(q[7]))

        answer.append(cnt)
    return answer
    
language_map = {"cpp" : 0, "java" : 1, "python" : 2}
occupation_map = {"backend" : 0, "frontend" : 1}
career_map = {"junior" : 0, "senior":1 }
soul_food_map = {"chicken" : 0, "pizza" : 1}

def solution(info, query):
    graph = [[[[[] for _ in range(2)] for _ in range(2)] for _ in range(2)] for _ in range(3)]
    
    for i in info:
        language, occupation, career, soul_food, score = i.split(" ")
        graph[language_map[language]][occupation_map[occupation]][career_map[career]][soul_food_map[soul_food]].append(int(score))
        graph[language_map[language]][occupation_map[occupation]][career_map[career]][soul_food_map[soul_food]].sort()
    
    return find_query(query, graph)
