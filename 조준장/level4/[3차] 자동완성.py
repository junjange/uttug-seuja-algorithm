def solution(words):
    answer = 0
    trie = {}
    for word in words:
        new_trie = trie
        for w in word:
            new_trie.setdefault(w, [0, {}])
            new_trie[w][0] += 1
            new_trie = new_trie[w][1]

    for word in words:
        new_trie = trie
        for i in range(len(word)):
            w = word[i]
            if new_trie[w][0] == 1:
                break
            new_trie = new_trie[w][1]
        answer += (i + 1)
    return answer
