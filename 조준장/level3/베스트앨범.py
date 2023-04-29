def solution(genres, plays):
    answer = []
    genres_hash = {}
    n = len(genres)

    for i in range(n):
        if genres[i] in genres_hash:
            genres_hash[genres[i]][i] = plays[i]
        else:
            genres_hash[genres[i]] = {i : plays[i]}

    new_hash = sorted(genres_hash.items(), key= lambda x : sum(x[1].values()), reverse = True)
    
    for key, value in new_hash:
        new_genres = sorted(value.items(), key=lambda x : x[1], reverse = True)
        cnt = 0

        for ng in new_genres:
            answer.append(ng[0])
            cnt += 1
            
            if cnt == 2:
                break
    
    return answer
