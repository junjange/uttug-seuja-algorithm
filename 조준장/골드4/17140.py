import sys
from collections import Counter


def empty_graph(new_graph):
    max_line = len(sorted(new_graph, reverse=True, key=lambda x: len(x))[0])
    for i in range(len(new_graph)):
        for _ in range(max_line - len(new_graph[i])):
            new_graph[i].append(0)

    return new_graph


def make_graph(lines):
    new_graph = []
    for line in lines:
        if line[0] != 0:
            new_graph += line
    return new_graph


def run(new_graph):
    r_graph = []
    for ng in new_graph:
        count_ng = list(Counter(ng).items())
        count_ng.sort(key=lambda x: (x[1], x[0]))
        mg = make_graph(count_ng)
        r_graph.append(mg)
    empty_graph(r_graph)

    return r_graph


def change(new_graph):
    change_graph = []
    for i in range(len(new_graph[0])):
        temp_graph = []
        for j in range(len(new_graph)):
            temp_graph.append(graph[j][i])
        change_graph.append(temp_graph)
    return change_graph


r, c, k = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(3)]
answer = -1
for _ in range(101):
    if r <= len(graph) and c <= len(graph[0]) and graph[r - 1][c - 1] == k:
        answer = _
        break
    if len(graph) >= len(graph[0]):

        graph = run(graph)
    else:
        graph = change(graph)
        graph = run(graph)
        graph = change(graph)


print(answer)
