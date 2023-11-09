import sys

n = int(sys.stdin.readline())
words = [list(str(sys.stdin.readline().strip())) for _ in range(n)]
answer = 0

for i in range(1, len(words)):
    cnt = 0
    first_word = words[0][::]
    for word in words[i]:
        if word in first_word:
            first_word.remove(word)
        else:
            cnt += 1

    if cnt < 2 and len(first_word) < 2:
        answer += 1

print(answer)
