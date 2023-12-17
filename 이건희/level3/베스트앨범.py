def solution(genres, plays):
    result = []
    total_plays = {}
    count = {}
    a = [1]

    for i in range(len(genres)):
        if genres[i] in total_plays:
            total_plays[genres[i]] += plays[i]
            count[genres[i]].append([plays[i], i])
        else:
            total_plays[genres[i]] = plays[i]
            count[genres[i]] = [[plays[i], i]]
            
    count = {key: sorted(value, key = lambda x : [x[0], -x[1]], reverse=True) for key, value in count.items()}
    total_plays = dict(sorted(total_plays.items(), key=lambda x: x[1], reverse=True))
    
    for i in total_plays:
        result += [sublist[1] for sublist in count[i][:2]]
        
    return result
