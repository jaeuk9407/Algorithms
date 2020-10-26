import sys
from collections import deque


def bfs(vertex):
    global STOP, visited, color
    color[vertex] = 1
    queue = deque([vertex])

    # queue에 내용물이 있고, STOP 플래그가 True가 아니면 반복 진행
    while queue and not STOP:
        e = queue.popleft()
        c = color[e]

        if visited[e]:
            continue

        # 현재 노드의 방문표시
        visited[e] = True
        # 현재 노드의 인접노드 중 이미 방문했거나, 현재 노드와 색이 같은 노드가 있으면 바로 정지
        for link in graph[e]:
            if visited[link] and color[e] == color[link]:
                STOP = True
                break

            # 방문하지 않은 노드들에 현재 노드의 반대되는 색을 칠하고, queue에 담기
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

    # 아예 분리된 그래프(그래프가 내부에서 독립적으로 2개 이상 존재하는 경우 e.g. 끊어진 그래프)
    for j in range(1, v+1):
        # 이미 한 쪽에서 STOP 플래그가 변경된 경우
        if STOP: break
        # STOP 플래그의 변경 없는 상황에서 끊어진 그래프의 다른 한쪽을 탐색시키기 위해 방문하지 않은 노드가 있다면 방문
        if not visited[j]:
            bfs(j)

    if STOP:
        sys.stdout.write("NO\n")
    else:
        sys.stdout.write("YES\n")





