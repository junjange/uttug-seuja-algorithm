import sys
from collections import Counter

n, m = map(int, sys.stdin.readline().split())
words = [str(sys.stdin.readline().rstrip()) for _ in range(n)]
long_words = [word for word in words if len(word) >= m]
word_count = Counter(long_words)
[print(w[0]) for w in sorted(word_count.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))]
