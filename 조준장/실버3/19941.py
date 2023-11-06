import sys

n, k = map(int, sys.stdin.readline().split())
words = ['X'] * k + list(map(str, sys.stdin.readline().rstrip())) + ['X'] * k
cnt = 0
for i in range(len(words)):
    if words[i] == 'P':
        for j in range(i-k, i+k+1):
            if words[j] == 'H':
                words[j] = 'X'
                cnt += 1
                break
print(cnt)
