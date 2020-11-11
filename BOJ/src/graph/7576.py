import sys
from collections import deque

m, n = map(int, sys.stdin.readline().split())
graph = []
queue = deque()
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

def bfs():
    while queue:
        # queue안에는 [x, y]로 들어있어 a, b로 받음
        a, b = queue.popleft()

        # 사전 정의된 움직임 범위에서 반복(상하좌우)
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]

            # 전체 그래프 범위 내 움직임이고, 아직 방문 X 할 때,
            if 0 <= x < n and 0 <= y < m and graph[x][y] == 0:
                # 1씩 더해서 매핑하고 queue에 삽입한다.
                graph[x][y] = graph[a][b] + 1
                queue.append([x, y])

# 받은 그래프에서 익은 토마토 지역을 먼저 Queue에 넣어놓는다.
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            queue.append([i, j])

bfs()

isTrue = False
result = -2

for i in graph:
    for j in i:
        # 만약 bfs 이후에도 0인 곳이 있다면 체크
        if j == 0:
            isTrue = True
        # result: 맵 내에서 최대값을 기록
        result = max(result, j)
        #print(result)

# 만약 bfs 이후에도 0인 곳이 있다면(접근 불가) 체크 후, -1 출력
if isTrue == True:
    sys.stdout.write(str(-1) + "\n")
# 가장 큰 값이 -1이면(토마토가 아예 없을 때) 0을 출력
#elif result == -1:
    #sys.stdout.write(str(0) + "\n")
else:
    sys.stdout.write(str(result -1) + "\n")