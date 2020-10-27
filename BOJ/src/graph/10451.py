import sys
sys.setrecursionlimit(10000)


def dfs(adj, vertex, visited):
    visited[vertex] = 1

    for i in adj[vertex]:
        if visited[i] == 0:
            dfs(adj, i, visited)


t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    p = sys.stdin.readline().split()
    adj= [[i] for i in range(n+1)]
    cnt = 0

    for i in range(1, n+1):
        adj[i].append(int(p[i-1]))
        adj[int(p[i-1])].append(i)

    visited = [0 for _ in range(n+1)]

    for i in range(1, n+1):
        if visited[i] == 0:
            dfs(adj, i, visited)
            cnt += 1
    print(cnt)
