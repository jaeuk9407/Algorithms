import sys
from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, list(input()))) for _ in range(n)]
q = deque();
visited = [[False] * m for _ in range(n)]
dist = [[0] * m for _ in range(n)]

# 시작점
q.append((0,0))
visited[0][0] = True
dist[0][0] = 1

while q:
    x, y = q.popleft()
    for k in range(4):
        nx, ny = x+dx[k], y+dy[k]
        if 0 <= nx < n and 0 <= ny < m:
            if visited[nx][ny] == False and graph[nx][ny] == 1:
                q.append((nx, ny))
                dist[nx][ny] = dist[x][y] + 1
                visited[nx][ny] = True

sys.stdout.write(str(dist[n-1][m-1]))
