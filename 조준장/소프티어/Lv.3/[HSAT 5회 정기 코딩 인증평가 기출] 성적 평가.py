import sys

def create_ranking(scores):
    ranking = [0] * n
    pre_score = 0
    rank = 1
    pre_rank = 0
    for score in scores:
        if pre_score == score[1]:
            pre_rank += 1
        elif pre_score > score[1]:
            rank += pre_rank + 1
            pre_rank = 0
            
        pre_score = score[1]
        ranking[score[0]] = rank
    
    return ranking
    

n = int(sys.stdin.readline())
answer = []
scores = [[], [], []]
total_scores = [[i, 0] for i in range(n)]
for i in range(3):
    score = list(map(int, sys.stdin.readline().split()))
    new_socres = []
    for j in range(n):
        new_socres.append([j, score[j]])
    scores[i] = sorted(new_socres, key=lambda x : -x[1])

    for k in range(n):
        total_scores[k][1] += score[k]
total_scores.sort(key=lambda x : -x[1])

for i in range(3):
    print(*create_ranking(scores[i]))

print(*create_ranking(total_scores))

