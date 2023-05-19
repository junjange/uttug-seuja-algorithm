def solution(n, costs):
    costs.sort(key=lambda x :(x[2]))
    link = set([costs[0][0], costs[0][1]])
    answer = costs[0][2]

    while len(link) < n:
        for cost in costs:
            if cost[0] in link and cost[1] in link:
                continue
            if cost[0] in link or cost[1] in link:
                link.update([cost[0], cost[1]])
                answer += cost[2]
                break
        
    return answer
