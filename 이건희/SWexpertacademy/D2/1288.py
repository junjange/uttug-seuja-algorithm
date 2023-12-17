T = int(input())
for test_case in range(1, T + 1):
    num = int(input())
    result = 0
    numList = set()
    while len(numList) != 10:
        result += 1
        now = num * result
        numList.update(list(str(now)))

    print(f"#{test_case} {now}")
