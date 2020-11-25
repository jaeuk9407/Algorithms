import sys
read = lambda : sys.stdin.readline().strip()
sys.setrecursionlimit(100000)

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# 지도 크기
n = int(read())
# 지도 정보 입력
a = [[int(i) for i in read().split()] for _ in range(n)]
# 지도 크기 2차원 리스트 생성(d: , g:섬정보)
d = [[0]*(n) for _ in range(n)]
g = [[0]*(n) for _ in range(n)]

# 섬의 개수 카운트
cnt = 0

for i in range(n):
    for j in range(n):
        # 육지이고, 방문하지 않은 경우
        if a[i][j] == 1 and g[i][j] == 0:
            q = []
            cnt += 1

            # 방문한 위치를 카운트 수로 mapping, q 리스트에 좌표 추가
            g[i][j] = cnt
            q.append((i, j))

            # q에 값이 담겨있으면 꺼내 주변 위치를 해당 카운트로 mapping 작업 반복 수행
            while len(q):
                x, y = q.pop(0)
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]
                    if 0 <= nx and nx < n and 0 <= ny and ny < n :
                        if a[nx][ny] == 1 and g[nx][ny] == 0:
                            g[nx][ny] = cnt
                            q.append((nx, ny))
print("g:", g)

q = []
for i in range(0, n):
    for j in range(0, n):
        d[i][j] = -1
        # 육지이면 q 리스트에 위치 정보 저장 및 0으로 mapping
        if a[i][j] == 1:
            q.append((i, j))
            d[i][j] = 0


# 처음에는 모든 육지, 이후 범위를 점차적으로 늘려가는 bfs로 거리 정보, 인접 섬 정보 저장
while len(q):
    x, y = q.pop(0)
    for k in range(0, 4):
        nx, ny = x + dx[k], y + dy[k]
        if 0 <= nx and nx < n and 0 <= ny and ny < n :
            # 인접 위치가 map 내부이고, 인접 지역이 바다이면
            if d[nx][ny] == -1 :
                # 인접 위치에 이전 위치의 거리 카운트에서 +1하여 저장
                d[nx][ny] = d[x][y] + 1
                # 인접 위치에 이전 위치의 섬 정보를 현재 위치에도 저장(섬 연결의 최소 거리를 탐색하기 위함)
                g[nx][ny] = g[x][y]
                q.append((nx, ny))

print("d:", d)
print("g:", g)
ans = -1
for i in range(0, n):
    for j in range(0, n):
        for k in range(0, 4):
            nx, ny = i + dx[k], j + dy[k]
            # 인접 위치가 map 내부이고,
            if 0 <= nx and nx < n and 0 <= ny and ny < n :
                # 현재 위치와 인접지역의 섬 정보가 다르면서

                if g[i][j] != g[nx][ny]:
                    # ans가 설정되지 않았거나
                    # 현재 위치와 인접 위의 거리 정보 (인접 섬 정보가 달라지는 위치에서 양쪽의 섬과의 거리)
                    # 를 더한 값이 현재 ans보다 작다면 ans 업데이트
                    if ans == -1 or ans > d[i][j] + d[nx][ny]:
                        ans = d[i][j] + d[nx][ny]

print(ans)
