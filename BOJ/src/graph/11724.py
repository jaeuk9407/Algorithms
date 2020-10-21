#오답 - 시간 초과

def dfs(graph, v, visited):
    # 현재 위치를 방문한 적이 없다면, 인접 노드 호출하고 True 처리
    if not visited[v]:
        visited[v] = True
        for i in range(len(graph[v])):
            # 인접한 노드 재귀 호출
            dfs(graph, graph[v][i], visited)
        #print("graph[v][i]: "+str(graph[v])+"returnTrue")
        return True
    return False


n, m = map(int, input().split())

graph = []

for i in range(n + 1):
    graph.append([])

for i in range(m):
    u, v = map(int, input().split())
    if v not in graph[u]:
        graph[u].append(v)
    if u not in graph[v]:
        graph[v].append(u)

visited = [False] * (n + 1)
result = 0
#print(graph)
for i in range(1, n+1):
    if not visited[i]:
        if dfs(graph, i, visited) == True:
            #print("result += 1!!!")
            result += 1

print(result)
