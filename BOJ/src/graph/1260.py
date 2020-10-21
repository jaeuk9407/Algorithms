from collections import deque


def dfs(graph, v, visited):
    # 현재 노드 방문처리
    visited[v] = True
    print(v, end=' ')
    # 현재 노드와 연결된 다른 노드를 재귀적으로 호출
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


def bfs(graph, v, visited):
    # Queue 구현
    queue = deque([v])
    # 현재 노드(시작 노드) 방문처리
    visited[v] = True

    while queue:
        v = queue.popleft()
        print(v, end=' ')

        # 아직 방문하지 않은 인접한 원소들을 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


n, m, v = map(int, input().split())

# graph의 간선정보를 담을 2차원 리스트 생성
graph = []
for i in range(n + 1):
    graph.append([])

# 입력 값을 해당 정점의 간선정보에 추가
for i in range(m):
    s, e = map(int, input().split())
    if e not in graph[s]:
        graph[s].append(e)
    if s not in graph[e]:
        graph[e].append(s)

# 낮은 숫자의 노드 순서로 탐색시키기 위해 정렬
for i in range(n):
    graph[i].sort()


# 각 노드가 방문된 정보를 표현(1차원 리스트)
visited = [False] * (n + 1)
# 정의된 DFS 함수 호출
dfs(graph, v, visited)

print()

# DFS가 끝나고 BFS를 위해 방문기록 초기화
visited = [False] * (n + 1)
bfs(graph, v, visited)
