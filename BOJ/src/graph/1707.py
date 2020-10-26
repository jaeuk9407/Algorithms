import sys
from collections import deque


def bfs(vertex, STOP, visited, color):
    color[vertex] = 1
    queue = deque([vertex])

    while queue and not STOP:
        e = queue.popleft()
        c = color[e]

        if visited[e]:
            continue

        visited[e] = 1
        for link in graph[e]:
            if visited[link] and color[e] == color[link]:
                STOP = True
                break

            elif not visited[link]:
                color[link] = -c
                queue.append(link)


k = int(sys.stdin.readline())

for i in range(k):
    v, e = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(v+1)]
    visited = [False]*(v+1)
    for j in range(e):
        n, m = map(int, sys.stdin.readline().split())
        graph[n].append(m)
        graph[m].append(n)

    color = [0] * (v+1)
    STOP = False

    for j in range(1, v+1):
        if STOP: break
        if not visited[j]:
            bfs(j, STOP, visited, color)

    if STOP:
        sys.stdout.write("NO\n")
    else:
        sys.stdout.write("YES\n")





