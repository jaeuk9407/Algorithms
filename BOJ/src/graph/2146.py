import sys
read = lambda : sys.stdin.readline().strip()
sys.setrecursionlimit(100000)

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

n = int(read())
a = [[int(i) for i in read().split()] for _ in range(n)]
d = [[0]*(n) for _ in range(n)]
g = [[0]*(n) for _ in range(n)]

cnt = 0

for i in range(n):
    for j in range(n):
        if a[i][j] == 1 and g[i][j] == 0:
            q = []
            cnt += 1
            g[i][j] = cnt
            q.append((i, j))
            while len(q):
                x, y = q.pop(0)
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]
                    if 0 <= nx and nx < n and 0 <= ny and ny < n :
                        if a[nx][ny] == 1 and g[nx][ny] == 0:
                            g[nx][ny] = cnt
                            q.append((nx, ny))
q = []
for i in range(0, n):
    for j in range(0, n):
        d[i][j] = -1
        if a[i][j] == 1:
            q.append((i, j))
            d[i][j] = 0

while len(q):
    x, y = q.pop(0)
    for k in range(0, 4):
        nx, ny = x + dx[k], y + dy[k]
        if 0 <= nx and nx < n and 0 <= ny and ny < n :
            if d[nx][ny] == -1 :
                d[nx][ny] = d[x][y] + 1
                g[nx][ny] = g[x][y]
                q.append((nx, ny))


ans = -1
for i in range(0, n):
    for j in range(0, n):
        for k in range(0, 4):
            nx, ny = i + dx[k], j + dy[k]
            if 0 <= nx and nx < n and 0 <= ny and ny < n :
                if g[i][j] != g[nx][ny]:
                    if ans == -1 or ans > d[i][j] + d[nx][ny]:
                        ans = d[i][j] + d[nx][ny]

print(ans)
