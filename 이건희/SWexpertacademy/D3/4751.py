T = int(input())
for test_case in range(1, T + 1):
    word = input()
    result = []
    for i in range(5):
        if i == 2:
            decoration = '#'
            for j in word:
                decoration += '.' + j + '.#'
            print(decoration)
             
        elif i % 2 == 0:
            decoration = '.' + '.#..' * len(word)
            print(decoration)
             
        else:
            decoration = '.' + '#.#.' * len(word)
            print(decoration)
