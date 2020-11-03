import sys
sys.setrecursionlimit(111111)

dx = [-1, 1, 0, 0, -1, 1, -1, 1]
dy = [0, 0, -1, 1, -1, 1, 1, -1]

def dfs(x,y):
    # 현재 위치 방문 처리
    visit[x][y] = 1

    # 상하좌우, 대각선 이동
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]

        # 이동하려는 위치가 이동 가능한 위치이고, 아직 방문하지 않았고, 육지라면 방문
        if 0 <= nx < h and 0 <= ny < w and visit[nx][ny] == 0 and graph[nx][ny] == 1:
            graph[nx][ny] = 0
            dfs(nx,ny)


while True:
    w, h = map(int, sys.stdin.readline().split())
    if w == 0 and h == 0:
        break
    graph =[]
    for _ in range(h):
        graph.append(list(map(int, sys.stdin.readline().split())))

    visit = [[0] * w for _ in range(h)]
    result = 0      # 섬의 개수
    for i in range(h):
        for j in range(w):
            # 아직 방문하지 않고, 육지라면 dfs 호출
           if visit[i][j] == 0 and graph[i][j] == 1:
                dfs(i, j)
                result += 1

    print(result)