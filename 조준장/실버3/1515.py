import sys

words = str(sys.stdin.readline().rstrip())
ans = 0

while True:
    ans += 1
    num = str(ans)

    while len(num) > 0 and len(words) > 0:
        if num[0] == words[0]:
            words = words[1:]

        num = num[1:]

    if words == '':
        print(ans)
        break
