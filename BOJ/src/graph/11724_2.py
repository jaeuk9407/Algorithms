# 오답 - 시간초과

# Default 재귀제한 확장
import sys
sys.setrecursionlimit(10000)


def dfs(v):
    visited[v] = True
    # 입력받은 위치의 인접노드 반복
    for e in adj[v]:
        if not visited[e]:
            dfs(e)


N, M = map(int, input().split())
adj = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)
count = 0

for _ in range(M):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

for j in range(1, N + 1):
    if not visited[j]:
        dfs(j)
        count += 1

print(count)